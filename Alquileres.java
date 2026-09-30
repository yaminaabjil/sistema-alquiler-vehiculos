
/**
 * La clase Alquileres representa el registro de cada viaje 
 * realizado por un cliente y toda la informacion relacionada con el 
 * mismo.
 * 
 * @author (Yamina Abjil) 
 */

import java.time.LocalDateTime;
import java.time.Duration;

public class Alquileres
{
   private Cliente cliente;
   private Vehiculo vehiculo;
   private Ubicacion inicio;
   private Ubicacion fin;
   private LocalDateTime horaInicio;
   private LocalDateTime horaFin;
   private double tarifa;
   
   //constructor
   public Alquileres (Cliente cliente, Vehiculo vehiculo, Ubicacion inicio, LocalDateTime horaInicio, double tarifa) {
       this.cliente=cliente;
       this.vehiculo=vehiculo;
       this.inicio=inicio;
       this.horaInicio=horaInicio;
       this.tarifa=tarifa;
   }
   
   public Cliente getCliente() {
       return cliente;
   }
   public Vehiculo getVehiculo() {
       return vehiculo;
   }
   public Ubicacion getInicio() {
       return inicio;
   }
   public Ubicacion getFin () {
       return fin;
   }
   public void setFin (Ubicacion fin) {
       this.fin= fin;
   }
   public LocalDateTime getHoraInicio() {
       return horaInicio;
   }
   public LocalDateTime getHoraFin() {
       return horaFin;
    }
   public void setHoraFin (LocalDateTime horaFin) {
       this.horaFin = horaFin;
   }
   public double getTarifa() {
       return tarifa;
   }
   public void setTarifa (double tarifa) {
       this.tarifa=tarifa;
   }
   
   //calcular duracion de un alquiler en minutos
   public long calcularDuracion() {
       if (horaFin != null) { //si el viaje ha comenzado..
           return Duration.between(horaInicio, horaFin).toMinutes(); //calcular el tiempo entre la hora de inicio y la final en min
       } else {
           return 0; //sino ha comenzado el viaje, devolver 0
       }
    }
   
   //imprimir informacion del alquiler
   public void imprimirAlquiler() {
       System.out.println("Cliente: " + cliente.getNombre());
       System.out.println("Vehiculo: " + vehiculo.getClass().getSimpleName());
       System.out.println("Inicio: " + inicio);
       if (fin != null) {
           System.out.println("Fin: " + fin);
       } else {
           System.out.println("Fin: No finalizado");
       }
       System.out.println("Hora inicio: " + horaInicio);
       if (horaFin != null)  {
           System.out.println("Hora fin: " + horaFin);
       } else {
           System.out.println("Hora fin: No finalizado");
       }
       System.out.println("Duracion: " + calcularDuracion() + "minutos");
       System.out.println("Tarifa: " + tarifa +" €");
   }
}
