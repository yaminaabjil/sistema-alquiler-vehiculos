
/**
 * En esta clase se puede gestionar todo lo relacionado con
 * los vehiculos del sistema
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;

public class GestionVehiculos
{
   private ArrayList<Vehiculo> flota;
   private static ArrayList<String> avisosReparacion = new ArrayList<>();
   private static ArrayList<String> avisosBateria = new ArrayList<>();
   private static ArrayList<Ubicacion> avisosBases = new ArrayList<>();

   
   public GestionVehiculos() {
       flota = new ArrayList<>();
   }
   //metodo para agregar vehiculo
   public void agregarVehiculo(Vehiculo v) {
       flota.add(v);
       System.out.println ("Vehiculo agregado: " + v.getMatricula());
   }
   //metodo para eliminar un vehiculo
   public void eliminarVehiculo(Vehiculo v) {
       flota.remove(v);
       System.out.println ("Vehiculo eliminado: " + v.getMatricula());
   }
   
   public ArrayList<Vehiculo> getFlota() {
       return flota;
   }
   
   //metodo para agregar un aviso
   public static void agregarAviso (Vehiculo v, String descripcion, String tipo, Cliente cliente) {
       String aviso = "Vehiculo " + v.getMatricula() + " - " + descripcion + " (Cliente: " + cliente.getNombre() + ")";
       
       if (tipo.equals("bateria")) {
           avisosBateria.add(aviso);
       } else {
           avisosReparacion.add(aviso);
       }
    } 
    
   public static ArrayList<String> getAvisosReparacion() {
        return avisosReparacion;
   }
   public static ArrayList<String> getAvisosBateria() {
        return avisosBateria;
   }
   
   
   
   //mostrar toda la lista de avisos
   public static void mostrarTodosAvisos() {
       if (avisosBateria.isEmpty() && avisosReparacion.isEmpty()) {
       System.out.println("No hay avisos registrados");
       } else {
           ArrayList<String> todos = new ArrayList  <>();
           todos.addAll(avisosReparacion);
           todos.addAll(avisosBateria);
           
           System.out.println("══✿══❪ Lista total de avisos ❫══✿══");
           for (int i=0; i < todos.size(); i++) {
               System.out.println((i+1) + "- " +  todos.get(i));
           }
       }
       System.out.println("✄-----------------------");
   }
   //mostrar solo la lista de avisos de bateria
   public static void mostrarAvisosBateria() {
       if (avisosBateria.isEmpty()) {
           System.out.println("No hay avisos registrados");
       } else {
           System.out.println("══✿══❪ Lista de avisos de bateria ❫══✿══");
           for (int i=0; i < avisosBateria.size(); i++) {
               System.out.println((i+1)+ "- " + avisosBateria.get(i));
           }
       }
       System.out.println("✄-----------------------");
   }
   //mostrar solo la lista de avisos de reparacion
   public static void mostrarAvisosReparacion() {
       if (avisosReparacion.isEmpty()) {
           System.out.println("No hay avisos registrados");
       } else {
           System.out.println("══✿══❪ Lista de avisos de reparacion ❫══✿══");
           for (int i=0; i < avisosReparacion.size(); i++) {
               System.out.println((i+1)+ "- " + avisosReparacion.get(i));
           }
       }
       System.out.println("✄-----------------------");
   }
   
   //metodo para mostrar que usario ha usado que vehiculo + fecha e importe
   public void mostrarUsoVehiculos(GestionPersonas gestionPersonas) {
       System.out.println("══✿══❪ Uso de Vehículos ❫══✿══");
       
       //recorrer la lista de clientes registrados
       for (int i=0; i < gestionPersonas.getClientes().size(); i++) {
           Cliente c = gestionPersonas.getClientes().get(i);
            
           //recorrer historial de viajes de cada cliente
           for (int j=0; j < c.getHistorialViajes().size(); j++) {
               Alquileres alquiler = c.getHistorialViajes().get(j);
               
               System.out.println("Usuario: " + c.getNombre());
               System.out.println("Vehiculo: " + alquiler.getVehiculo().getMatricula());
               System.out.println("Fecha inicio: " + alquiler.getHoraInicio());
               if (alquiler.getHoraFin() != null) {
                   System.out.println("Fecha fin: " + alquiler.getHoraFin());
               } else {
                   System.out.println("Aun esta en uso.");
               }
               System.out.println("Importe: " + alquiler.getTarifa() + " €");
               System.out.println("✄-----------------------");
           }          
       }
   }
 
}
