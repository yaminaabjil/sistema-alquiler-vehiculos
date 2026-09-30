
/**
 * Clase Vehiculo: sirve como modelo general de todos los tipos de vehiculos del sistema,
 * en la que hemos definido todos los metodos comunes.
 * 
 * @author (Yamina Abjil) 
 * 
 */

import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Vehiculo
{
 public String matricula; 
 public double bateria; //porcentaje del 0 al 100
 public boolean averiado;
 public Ubicacion ubicacion; //la ubicacion de los vehiculos
 private String tipo; //"moto", "bici", "patinete"
 private boolean reservado; //indica si el vehiculo esta reservado o no
 private LocalDateTime horaReserva; //momento en que empezo la reserva
 private boolean estaDisponible;
 private double tarifa;
 
 //constructor
 public Vehiculo(String matricula, double bateria, Ubicacion ubicacion, boolean reservado, double tarifa){
     this.matricula=matricula;
     this.bateria=bateria;
     this.averiado=false; //por defecto no esta averiado
     this.ubicacion=ubicacion; 
     this.tipo=tipo;
     this.reservado=reservado;
     this.horaReserva=null;
     this.tarifa=tarifa;
 }
 
 public String getMatricula() {
     return matricula;
 }
 public Ubicacion getUbicacion() {
     return ubicacion;
 }
 public void getUbicacion (Ubicacion ubicacion) {
     this.ubicacion = ubicacion;
 }
 public double getBateria() {
     return bateria;
 }
 public void setBateria (double bateria) {
     if (bateria < 0) bateria = 0;
     if (bateria > 100) bateria = 100;
     this.bateria=bateria;
 }   
 public boolean isAveriado() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
     return averiado;
 }
 public void setAveriado (boolean averiado) {
     this.averiado = averiado;
 }
 public String getTipo() {
     return tipo;
 }
 public double getTarifa() {
     return this.tarifa;
 }
 public void setTarifa(double tarifa) {
     this.tarifa=tarifa;
 }
 
 //metodos para la reserva
 public boolean isReservado() {
     return reservado;
 }
 //metodo para reservar un vehiculo
 public void reservar() {
     this.reservado=true;
     this.horaReserva=LocalDateTime.now();
 }
 //metodo para dejar de reservar un vehiculo
 public void deshacerReserva() {
     this.reservado=false;
     this.horaReserva=null;
 }
 //saber si la reserva est aactiva (20 min)
 public boolean reservaActiva() {
     if (!reservado || horaReserva == null) {
         return false;
     }
     return Duration.between(horaReserva, LocalDateTime.now()).toMinutes() < 20;
     //si la duracion de la reserva es mayor a 20, la reserva se cancela
 }
 
 //metodo para comprobar si el vehiculo esta disponible
 public boolean estaDisponible() {
     boolean noAveriado = !averiado; //el vehiculo no esta averiado
     boolean bateriaSuficiente = bateria >20; //bateria mayor al 20%
     boolean noReservado = !reservado; //no este reservado
     
     if (noAveriado && bateriaSuficiente && noReservado) {
         return true; //vehiculo disponible
     } else {
         return false; //vehiculo no disponible
     }
 }
 
 //metodo para consumir la bateria segun el tiempo de uso
 public abstract void consumirBateria (double minutos);
 
 //metodo para mostrar informacion basica de cada vehiculo
 public void imprimeInfo() {
    System.out.println("Tipo de vehiculo: " + this.getClass().getSimpleName());
    System.out.println("Bicicleta " + this.matricula);
    System.out.println("Batería: " + this.bateria + "%");
    if (averiado) {
    System.out.println("Averiado: Sí");
    } else {
    System.out.println("Averiado: No");
    }
    if (reservado) {
        System.out.println ("Estado: Reservado");
    } else {
        System.out.println ("Estado: Disponible");
    }
    if (estaDisponible = false) {
        System.out.println ("Estado: No disponible");
    }
    System.out.println("------------------------"); 
 }
}




















// private String vehiculo;
  //private double precio;
  //private double bateria;

//public Vehiculo (String vehiculo, double precio, double bateria) {
   // this.vehiculo=vehiculo;
   // this.precio=precio;
   // this.bateria=bateria;
//}
//public void Vehiculo (){}
//public String getVehiculo(){
  //  return this .vehiculo;
//}
//public void setVehiculo (String vehiculo){
  //  this.vehiculo=vehiculo;
//}
//public double getPrecio (){
   // return this.precio;
//}
//public void setPrecio (double precio){
 //   this.precio=precio;
//}
//public double getBateria (){
 //   return this.bateria;
//}
//public void setBateria (double bateria){
 //   this.bateria=bateria;
//}

//public void imprimeVehiculo(){
   // System.out.println("Tipo de vehiculo: " + this.vehiculo);
   // System.out.println("Precio: " + this.precio);
  //  System.out.println("Bateria; " + this.bateria);
//}