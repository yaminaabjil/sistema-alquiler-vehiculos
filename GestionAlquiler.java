
/**
 * En esta clase se gestiona todo lo relacionado con el alquiler
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;
import java.time.LocalDateTime;

   public class GestionAlquiler{
    private ArrayList<Alquileres> alquileres; 
    
    public GestionAlquiler() {
        this.alquileres = new ArrayList<>();
    } 
    
    
    //iniciar un alquiler
    public void iniciarAlquiler (Cliente cliente, Vehiculo vehiculo, Ubicacion inicio) {
        //comprobar si el vehiculo esta disponible segun el tipo de cliente
        double bateriaMinima;
        if (cliente.getTipoCliente().equals("Premium")) {
            bateriaMinima = 10;
        } else {
            bateriaMinima = 20;
        }
        if (vehiculo.isAveriado()) {
            System.out.println("Vehiculo no diponible, esta averiado");
            return;
        }
        if (!vehiculo.estaDisponible()) {
            System.out.println("El vehiculo no esta disponible");
            return;
        }
        if (vehiculo.getBateria() < bateriaMinima) {
            System.out.println("Vehiculo no tiene bateria suficiente.");
            return;
        }
        if (cliente.getSaldo() <= 0) {
            System.out.println("Saldo insuficiente para iniciar el alquiler.");
            return;
        }
        
        System.out.println("Bases disponibles para iniciar un alquiler:");
        boolean algunaDisponible = false;
        for  (int i=0; i < Ubicacion.getBases().size(); i++) {
            Ubicacion base = Ubicacion.getBases().get(i);
            if (base.estaDisponible(Ubicacion.getBases())) {
                System.out.println("- Base en " + base + " con plazas libres");
                algunaDisponible = true;
            }
        }
        //crear el alquiler y agregar al historial
        Alquileres alquiler = new Alquileres(cliente, vehiculo, inicio, LocalDateTime.now(), 0.0);
        alquileres.add(alquiler);
        cliente.addAlquiler(alquiler);
        inicio.ocuparPlaza();
        vehiculo.isReservado();
        
        System.out.println("Alquiler inciado coorectamente para " + cliente.getNombre() + " con el vehiculo " + vehiculo.getMatricula());
        
       
    }

    //metodo para finalizar un alquiler 
    public void finalizarAlquiler (Alquileres alquiler, Ubicacion fin) {
        if (alquiler.getFin() != null) {
            System.out.println("Este alquiler ya ha sido finalizado");
            return ;
        }
        
        alquiler.setFin(fin);
        alquiler.setHoraFin(LocalDateTime.now());
        
        Vehiculo v = alquiler.getVehiculo();
        if (v instanceof Bicicleta || v instanceof Patinete) {
            //verificar que la base esta disponible
            if (!fin.estaDisponible(Ubicacion.basesEnReparacion)) {
                System.out.println("La base de destino no esta disponible o esta en reparacion.");
                return;
            }
            //liberar la plaza
            fin.liberarPlaza();
            
        } else if (v instanceof Moto) {
            //comprobar los limites de la ciudad
            double x = fin.getX();
            double y = fin.getY();
            double limiteX = 100;
            double limiteY = 100;
            if (x < 0 || x > limiteX || y < 0 || y > limiteY) {
                System.out.println("La moto debe finaliar dentro de los limites de la ciudad.");
                return;
            }
        }
        
        //calcular duracion y tarifa
        double duracion = alquiler.calcularDuracion();
        double tarifa = alquiler.getVehiculo().getTarifa() * duracion;
        
        //aplicar descuento si es premium
        if (alquiler.getCliente().getTipoCliente().equals("Premium")) {
            double descuento = 0.30;
            tarifa = tarifa * (3-descuento);
        }
        
        alquiler.setTarifa(tarifa);
        
        //actualizar el saldo del cliente
        Cliente c = alquiler.getCliente();
        c.setSaldo(c.getSaldo() - tarifa);
        
        //actualizar bateria del vehiculo
        Vehiculo vv = alquiler.getVehiculo();
        vv.consumirBateria(duracion);
        
        System.out.println("Alquiler finalizado. Duracion: " + duracion + " minutos. Tarifa: " + tarifa + " €");       
    }
    
    //metodo para mostrar todos los alquileres
    public void mostrarAlquileres() {
        if (alquileres.isEmpty()) {
            System.out.println("No hay alquileres registrados.");
            return;
        }
        for (int i=0; i < alquileres.size(); i++) {
            alquileres.get(i).imprimirAlquiler();
        }
    }
}
