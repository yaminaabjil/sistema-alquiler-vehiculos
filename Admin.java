 
/**
 * Representa el trabajador superior a todos, que gestiona
 * el sistema por completo
 * 
 * @author (Yamina Abjil) 
 */

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class Admin extends Trabajadores
{
    
    //constructor
   public Admin (String nombre, String dni, double telefono, String idEmpleado) {
       super(nombre, dni, telefono, idEmpleado, "Administrador");
   }
   
   //metodos para dar de alta/baja/modificar datos de usuarios
   public void altaUsuario (GestionPersonas gestion, Cliente cliente) {
       gestion.agregarCliente(cliente);
       System.out.println("El administrador ha dado de alta a " + cliente.getNombre());
   }
   public void bajaUsuario (GestionPersonas gestion, Cliente cliente) {
       gestion.eliminarCliente(cliente); //eliminar
       System.out.println("El administrador ha dado de baja a " + cliente.getNombre());
   }
   public void modificarUsuario(GestionPersonas gestion,Cliente cliente, String nuevoNombre, double nuevoTelefono, String nuevoTipoCliente) {
      gestion.modificarUsuario(cliente.getNombre(), nuevoNombre, nuevoTelefono, nuevoTipoCliente);
    }
   
   //visualizar la lista de clientes
   public void verClientes (ArrayList<Cliente> clientes, GestionPersonas gestionPersonas) {
       if (clientes.isEmpty()) { //si la lista de clientes esta vacia 
           System.out.println("No hay clientes registrados");
       } else { //sino, imprimelos
           gestionPersonas.listaClientes();
       }
   }
    
   //visualizar el uso de cada vehiculo
   public void mostrarUsoVehiculos (GestionPersonas gestionPersonas,GestionVehiculos gestionVehiculos) {
       gestionVehiculos.mostrarUsoVehiculos(gestionPersonas);
   }

   //________ Metodos para promover un usuario a premium________
   //el usuario tiene que cumplir una de 3 condiciones para ser premium
   
   //CONDICION A: HABER VIAJADO 15 VECES EN ULTIMO MES
   private boolean cumpleCondA (Cliente cliente) {
       LocalDate hoy = LocalDate.now();
       YearMonth mesActual = YearMonth.from(hoy).minusMonths(1); //ultimo mes completo (calendario)
       int contador = 0;
       
       for (int i = 0; i < cliente.getHistorialViajes().size(); i++) {
           Alquileres a = cliente.getHistorialViajes().get(i);
           if (YearMonth.from(a.getHoraInicio().toLocalDate()).equals(mesActual)) { 
               contador ++;
           }
       }
       if (contador >= 15) {
           return true;
       } else {
           return false;
       }
   }
   
   //CONDICION B: HABER REALIZADO 10 VIAJES EN CADA UNO DE LOS 3 MESES ANTERIORES AL MES ACTUAL
   private boolean cumpleCondB (Cliente cliente) {
       LocalDate hoy = LocalDate.now();
       
       //recorremos los 3 meses anteriores al actual
       for (int i= 0; i < 3; i++) {
               YearMonth mes = YearMonth.from(hoy).minusMonths(i+1); //mes objetivo
               int contador = 0;
               
               //recorremos todo el historial y contamos los viajes hasta llegar al objetivo
               for (int j=0; j < cliente.getHistorialViajes().size(); j++) {
                   Alquileres alquiler = cliente.getHistorialViajes().get(j);
                   YearMonth mesAlquiler = YearMonth.from(alquiler.getHoraInicio().toLocalDate());
                   
                   if (mesAlquiler.equals(mes)) {
                       contador ++;
                   }
               }
               //si en algun mes hay menos de 10 viajes, no cumple con la condicion
               if (contador < 10) {
                   return false;
               }
       }
       //si los 3 meses cumplen la condicion, devolvemos true.
       return true;
       }
   //CONDICION C: USAR LOS 3 TIPOS DE VEHICULOS AL MENOS UNA VEZ CADA UNO EN LOS ULTIMOS 6 MESES
   private boolean cumpleCondC (Cliente cliente) {
       LocalDate hoy = LocalDate.now();
       
       //booleanos para cada tipo de vehiculo
       boolean bici = false;
       boolean patinete = false; 
       boolean moto = false;
       
       //recorremos el historial de viajes del cliente 
       for (int i=0; i < cliente.getHistorialViajes().size(); i++) {
           Alquileres alquiler = cliente.getHistorialViajes().get(i);
           LocalDate fecha = alquiler.getHoraInicio().toLocalDate();
           //volviendo hacia atras 6 meses contando desde la fecha de hoy
           if (fecha.isAfter(hoy.minusMonths(6))) {
               String tipo = alquiler.getVehiculo().getClass().getSimpleName();
               
               if (tipo.equals("Bicicleta")) {
                   bici = true;
               } else if (tipo.equals("Patinete")) {
                   patinete = true;
               } else if (tipo.equals("MotoPequena") || tipo.equals("MotoGrande")) {
                   moto = true;
               }
           }
       }
       //devuelve true si los 3 tipos de vehiculos han sido usados
       return bici && patinete && moto;
   }
   //evaluar si un cliente puede ser premium
   public boolean cumpleCondicionesPremium (Cliente cliente) {
       return cumpleCondA(cliente) || cumpleCondB(cliente) || cumpleCondC(cliente);
   }
   //promover usuario a premium si cumple 
   public void serPremium (Cliente cliente) {
       if (cliente.getTipoCliente().equals("Estandar") && cumpleCondicionesPremium(cliente)) { //si es estandar y cumple con las condiciones
           cliente.setTipoCliente("Premium"); //aregar a premium
           System.out.println("El cliente " + cliente.getNombre() + " ha sido promovido a Premium");
       } else {
           System.out.println("El cliente " + cliente.getNombre() + " no cumple las condiciones para ser Premium");
       }
   }
   
   //agregar una nueva base
   public void agregarBase(double x, double y) {
       Ubicacion.agregarBase(x, y);
   }
   //eliminar una base
   public void eliminarBase(Ubicacion base) {
       Ubicacion.eliminarBase(base);
   }
   
   //visualizar la lista de estado de bateria de los vehiculos
   public void visualizarEstadoBateria(GestionVehiculos gestion) {
       System.out.println("══✿══❪ Estado de baterias de la flota ❫══✿══");
       ArrayList<Vehiculo> flota = gestion.getFlota();
       
       for (int i=0; i < flota.size(); i++) {
           Vehiculo v = flota.get(i);
           System.out.println((i+1) + "- " + v.getClass().getSimpleName() + " | Matrcicula: " + v.getMatricula() + " | Bateria: " + v.getBateria() + "%");
       }
       System.out.println("✄-----------------------");
   }
   
   //visualizar los avisos
   public void verAvisos() {
       if (GestionVehiculos.getAvisosReparacion().isEmpty() && GestionVehiculos.getAvisosBateria().isEmpty()){
           System.out.println("No hay avisos registrados");
       } else {
           System.out.println("══✿══❪ Lista de avisos de reparacion de vehiculos❫══✿══");
           for (int i=0; i < GestionVehiculos.getAvisosReparacion().size(); i++) {
               System.out.println((i+1) + "- " + GestionVehiculos.getAvisosReparacion().get(i));
           }
           System.out.println("✄-----------------------");
           System.out.println("══✿══❪ Lista de avisos de bateria ❫══✿══");
           for (int i=0; i < GestionVehiculos.getAvisosBateria().size(); i++) {
               System.out.println((i+1) + "- " + GestionVehiculos.getAvisosBateria().get(i));
           }
           System.out.println("✄-----------------------");
           System.out.println("══✿══❪ Lista de avisos de reparacion de base ❫══✿══");
           for (int i=0; i < Ubicacion.getBasesEnReparacion().size(); i++) {
               System.out.println((i+1) + "- " + Ubicacion.getBasesEnReparacion().get(i));
           }
           System.out.println("✄-----------------------");
       }
       
   }
   //asignar las tareas al mecanico y al personal del mantenimiento
   public void asignarTareas (Mecanico mecanico, Mantenimiento mantenimiento) {
       //asignar los avisos de reparacion de vehiculo al mecanico
       for ( int i=0; i< GestionVehiculos.getAvisosReparacion().size(); i++) {
           String aviso = GestionVehiculos.getAvisosReparacion().get(i);
           mecanico.recibirAvisos(aviso);
       }
       //asignar los avisos de recargar bateria al personal del mantenimiento
       for ( int j=0; j< GestionVehiculos.getAvisosBateria().size(); j++) {
           String aviso = GestionVehiculos.getAvisosBateria().get(j);
           mantenimiento.recibirAvisos(aviso);
       }
       //asignar los avisos de reparacion de bases al mecanico
       for (int k=0; k < Ubicacion.getBasesEnReparacion().size(); k++) {
           String aviso = Ubicacion.getBasesEnReparacion().get(k).toString();
           mecanico.recibirAvisos(aviso);
       }
   }
   
   

}
   
   


   
   
   
   
   
   
   
   
   
   

