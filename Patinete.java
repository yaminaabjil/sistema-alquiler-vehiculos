
/**
 *Esta es la subclase Patinete heredada de la clase Vehiculo
 *que representa uno de los 3 vehiculos que se pueden alquilar
 *en el sistema, que es el patinete
 * 
 * @author (Yamina Abjil) 
 */
public class Patinete extends Vehiculo
{
  public Patinete (String matricula, double bateria, Ubicacion ubicacion, boolean reservado, double tarifa){
      super(matricula, bateria, ubicacion, reservado, tarifa);
  }
  
  //Implementacion del metodo abstracto consumirBateria
  //como se indica en el enunciado, el consumo de bateria en 
  //el caso de los patinetes pues es 0.5% por minuto.
  public void consumirBateria (double minutos) {
      double consumo = minutos * 0.5; //0.5% por minuto
      bateria = bateria - consumo;
      if (bateria < 0) { //para que la bateria nunca sea negativa
          bateria = 0; 
      }
  }
  
  //metodo para mostrar el tipo de vehiculo
  public String getTipo() {
      return "Patinete";
  }
  
  //Metodo para mostrar la informacion del patinete
  public void infoPatin() {
    System.out.println("Patinete " + this.matricula);
    System.out.println("Batería: " + this.bateria + "%");
    System.out.println("Averiada: " + this.averiado);
    System.out.println("Ubicacion: " + this.ubicacion);
    System.out.println("------------------------");
  }
}