
/**
 * Esta clase es clase UsuarioEstandar, hereredada de la clase Cliente. 
 * Representa el cliente normal que paga las tarifas completas
 * 
 * @author (Yamina Abjil) 
 */
public abstract class UsuarioEstandar extends Cliente
{
    //constructor
   public UsuarioEstandar(String nombre, String dni, double telefono, double saldo) {
       super(nombre, dni, telefono, saldo, "Estandar");
   }
   
   //el usuario estandar paga las tarifas completas
   public double calcularTarifa (double tarifaBase) {
     return tarifaBase;
   }
   
   //comprobar la bateria es de 20% o mas
   public boolean puedeUsarVehiculo (double bateria){
       return bateria >= 20; //si es true entonces el usuario podra alquilar el vehiculo
   }
   
   //el usuario estandar no puede reservar un vehiculo
   public boolean puedeReservar() {
       return false; 
   }
   
   //metodo para aplicar la penalizacion
   public void verificarBateria(Vehiculo v) {
       if (v.getBateria() < 20) {
          aplicarPenalizacion(1); //penalizacion de 1 €
        }
   }
}
