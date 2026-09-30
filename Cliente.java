/**
 * Esta clase Cliente representa los usuarios del sistema que pueden alquilar
 * vehiculos
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;

public abstract class Cliente extends Persona
{
 protected ArrayList<Alquileres> historialViajes;

 private double saldo;
 private String tipoCliente; 
 
 public Cliente (String nombre, String dni,double telefono, double saldo, String tipoCliente){
     super(nombre,dni,telefono);
     this.historialViajes = new ArrayList<>();
     this.saldo = saldo;
     this.tipoCliente = tipoCliente;
 }
 
 
 //metodos para el saldo
 public double getSaldo() {
     return this.saldo;
 }
 public void setSaldo (double saldo) {
     this.saldo = saldo;
 }
 public void recargarSaldo (double cantidad) { //metodo para recargar saldo
     this.saldo= this.saldo + cantidad;
     System.out.println ("Saldo recargado. Nuevo saldo: " + this.saldo);
 }
 
 //metodo general sobre las tarifas
 public double calcularTarifa (double tarifaBase) {
     return tarifaBase;
 }
 //metodo de la penalizacion si el vehiculo se entrega con baja bateria
 public void aplicarPenalizacion(double importe) {
     saldo = saldo - importe;
     System.out.println(getNombre() + " ha recibido una penalizacion de " + importe + " €.");
     System.out.println("Saldo actual: " + saldo);
 }
 
 //metodo para poder reservar
 public boolean puedeReservar() {
        return false; // por defecto ningún cliente puede reservar
    }
    
 //metodo para comprobar si se puede reservar un vehiculo o no 
 public boolean reservarVehiculo(Vehiculo v) {
     if (this.puedeReservar() && !v.reservaActiva()) { //si el usuario es premium y el vehiculo no esta reservado
         v.reservar(); //reservar el vehiculo
         System.out.println(getNombre() + " ha reservado el vehiculo: " + v.getMatricula());
         return true;
     } else { //sino cumple con las condiciones de arriba no podra reservar el vehiculo
          System.out.println(getNombre() + " no puede reservar este vehiculo: " + v.getMatricula());
         return false;
     }
 }
 
 public abstract boolean puedeUsarVehiculo(double bateria);

 //método para el tipo de cliente 
 public String getTipoCliente() {
     return this.tipoCliente;
 }
 public void setTipoCliente (String tipoCliente){
     this.tipoCliente = tipoCliente;
 }
 
 //metodo para el alquiler
 public void addAlquiler(Alquileres alquiler) {
     historialViajes.add(alquiler);
 }
 
 //reportar un fallo mecanico
 public void reportarFalloVehiculo (Vehiculo v, String descripcion, String tipo, Cliente cliente) {
     System.out.println (getNombre() + " ha reportado un fallo en el vehiculo: " +v.getMatricula());
     System.out.println ("Descripcion del problema: " + descripcion);
     System.out.println ("Tipo de aviso(Reparacion o bateria): " + tipo);
     
     //llamar a la gestion central para almacenar el aviso
     GestionVehiculos.agregarAviso(v, descripcion, tipo, cliente);
     //marca el vehiculo como averiado
     v.setAveriado(true);
 }
 //recibir notoficacion de que la reparacion hah sido completa
 public void notificarReparacion(String descripcion, double importe) {
     System.out.println("Estimado cliente " + getNombre() + ", tu vehiculo con aviso '" + descripcion + "' ha sido reparado.");
     System.out.println("El importe de la factura es: " + importe + " €");
 }
 
 //reportar un fallo en una base
 public static void reportarFalloBase (Ubicacion base, Cliente cliente) {
     System.out.println(cliente.getNombre() + " ha reportado un fallo en la base: " + base);
     Ubicacion.reportarFalloBase(base);
 }

 //metodos para el historial de viajes
 public void agregarViaje (Alquileres viaje) {
     this.historialViajes.add(viaje);
 }
 //mostrar la lista de alquileres
 public void mostrarHistorial () {
     System.out.println("Historial de viajes de " + getNombre() + ":");
     for (int i=0; i < historialViajes.size(); i++) {
         Alquileres viaje = historialViajes.get(i);
         System.out.println("- " + viaje);
     }
 }

 public ArrayList<Alquileres> getHistorialViajes() {
     return historialViajes;
 }
 
 
 
 //metodo para imprimir la informacion completa del cliente 
 public void imprimirCliente () {
     super.imprimirPersona();
     System.out.println("Tipo de cliente: " + this.tipoCliente);
     System.out.println("Saldo: " + this.saldo);
     mostrarHistorial();
 }
}
