
/**
 * Representa uno de los 3 trabajadores que el el Personal
 * del mantenimiento. Su funcion es recargar los
 * vehiculos.
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;


public class Mantenimiento extends Trabajadores
{
   private ArrayList<String> avisosPendientes = new ArrayList<>();
    
    
    //constructor
   public Mantenimiento (String nombre, String dni, double telefono, String idEmpleado) {
       super(nombre, dni, telefono, idEmpleado, "Personal del matenimiento");
   }
   
   //metodo para recargar un vehiculo
   public void recargarVehiculo (Vehiculo v) {
       v.setBateria(100);
       System.out.println("El encrgado de mantenimiento recargo el vehiculo: " + v.getMatricula());
   }
   public void recogerVehiculo (Vehiculo v) {
       System.out.println("El encargado de mantenimiento recogio el vehiculo: " + v.getMatricula());
   }
   
   //metodo para recibir los avisos
    public void recibirAvisos(String aviso) {
       System.out.println("Personal del mantenimiento: " + getNombre() + " recibio aviso: " + aviso);
   }
   public void mostrarAvisos() {
       System.out.println("══✿══❪ Lista de avisos pendientes ❫══✿══");
       for (int i=0; i < avisosPendientes.size(); i++) {
           System.out.println((i+1) + "- " + avisosPendientes.get(i));
       }
       System.out.println("✄-----------------------");
   }
   //marcar un aviso como completado, lo elimina de la lista y genera la factura
   public void completarReparacion (Vehiculo v, String aviso, double importe, Cliente cliente, double bateria) {
       if (avisosPendientes.remove(aviso)) {
           v.setBateria(100);
           
           System.out.println("Vehiculo reparado: " + v.getMatricula());
           System.out.println("Factura generada: " + importe + " €");
       
           //marcar el vehiculo como disponible de nuevo
           v.setAveriado(false);
           
           //notificar al cliente
           cliente.notificarReparacion(aviso, importe);
        } else {
           System.out.println("Aviso no encontrado.");
       }
   }
   
}
