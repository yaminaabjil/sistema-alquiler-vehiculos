
/**
 *Esta es la subclase Bicicleta heredada de la clase Vehiculo
 *que representa uno de los 3 vehiculos que se pueden alquilar
 *en el sistema, que es la bicicleta
 * 
 * @author (Yamina Abjil) 
 */
public class Bicicleta extends Vehiculo
{
  public Bicicleta (String matricula, double bateria, Ubicacion ubicacion, boolean reservado, double tarifa){
      super(matricula, bateria, ubicacion, reservado, tarifa);
  }

  //Implementacion del metodo abstracto consumirBateria
  //como se indica en el enunciado, el consumo de bateria en 
  //el caso de las bicis pues es 1% por minuto.
  public void consumirBateria (double minutos) {
      double consumo = minutos * 1.0; //1% por minuto
      bateria = bateria - consumo;
      if (bateria < 0) { //para que la bateria nunca sea negativa
          bateria = 0; 
      }
  }
  
  //metodo para mostrar el tipo de vehiculo
  public String getTipo() {
      return "Bicicleta";
  }
  
  //Metodo para mostrar la informacion de la bicicleta.
  public void infoBici() {
    System.out.println("Bicicleta " + this.matricula);
    System.out.println("Batería: " + this.bateria + "%");
    System.out.println("Averiada: " + this.averiado);
    System.out.println("Ubicacion: " + this.ubicacion);
    System.out.println("------------------------");
  }
}
