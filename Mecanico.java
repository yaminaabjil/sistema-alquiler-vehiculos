
/**
 * Representa el tipo de Trabajador Mecanico, que 
 * se encarga de reparar los vehiculos y las bases averiadas
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;


public class Mecanico extends Trabajadores
{
   private ArrayList<String> avisosPendientes = new ArrayList<>();
    
    
   //constructor
   public Mecanico (String nombre, String dni, double telefono, String idEmpleado) {
       super(nombre, dni, telefono, idEmpleado, "Mecanico");
   }
   
    
   //metodo para recibir los avisos
   public void recibirAvisos(String aviso) {
       avisosPendientes.add(aviso);
       System.out.println("Mecanico: " + getNombre() + " recibio aviso: " + aviso);
   }
   //metodo para mostrar los avisos
   public void mostrarAvisos() {
       System.out.println("══✿══❪ Lista de avisos pendientes ❫══✿══");
       for (int i=0; i < avisosPendientes.size(); i++) {
           System.out.println((i+1) + "- " + avisosPendientes.get(i));
       }
       System.out.println("✄-----------------------");
   }
   //marcar un aviso como completado, lo elimina de la lista y genera la factura
   public void completarReparacion (Vehiculo v, String aviso, double importe, Cliente cliente) {
       if (avisosPendientes.remove(aviso)) {
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
   
   //marcar una base como reparada
   public void completarReparacionBase (Ubicacion base) {
       if (Ubicacion.getBasesEnReparacion().contains(base)) {
           Ubicacion.repararBase(base);
           System.out.println("La base: " + base + " ha sido reparada.");
       }
   }
}
