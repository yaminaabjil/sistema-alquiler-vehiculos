
/**
 * Esta clase es clase UsuarioPremium, hereredada de la clase Cliente. 
 * Representa el cliente que disfruta de beneficios como descuentos, 
 * reservar el vehiculo 20 minutos antes y poder alquilar un vehiculo con
 * 10 de bateria
 * 
 * @author (Yamina Abjil) 
 */
public abstract class UsuarioPremium extends Cliente
{
    private double descuento; //% de descuento en las tarifas
    
    //constructor
    public UsuarioPremium(String nombre, String dni, double telefono, double saldo) {
        super(nombre, dni, telefono,saldo, "Premium");
        this.descuento=descuento;
    }
    
    //descuentos
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento (double descuento) {
        this.descuento=descuento;
    }
    
    //metodo que aplica el descuento sobre una tarifa
    public double aplicarDescuento (double tarifaBase) {
        return tarifaBase - (tarifaBase * descuento / 100);
    }
    
    //metodo para poder usar vehiculos de 10% de bateria
    public boolean puedeUsarVehiculo (double bateria) {
        return bateria >= 10; 
    }
    
    //el usuario premium puede reservar un vehiculo 20 min antes
    public boolean puedeReservar() {
        return true;
    }
    
    //metodo para aplicar la penalizacion
   public void verificarBateria(Vehiculo v) {
       if (v.getBateria() < 10) {
          aplicarPenalizacion(1); //penalizacion de 1 €
        }
   }
}
