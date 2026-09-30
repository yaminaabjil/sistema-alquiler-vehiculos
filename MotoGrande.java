
/**
 * La subclase de Moto que representa la Moto de mayor cilindrada 
 * 
 * @author (Yamina Abjil) 
 */
public class MotoGrande extends Moto
{
  //constructor
  public MotoGrande (String matricula, double bateria, Ubicacion ubicacion, boolean reservado, double tarifa) {
       super(matricula, bateria, ubicacion, reservado, tarifa);
  }
  
  //metodo para mostrar el tipo de vehiculo
  public String getTipo() {
      return "Moto Grande";
  }
  
  //Implementacion del metodo abstracto consumirBateria
  //como se indica en el enunciado, el consumo de bateria en 
  //el caso de las motos grandes pues es 0.25% por minuto.
  public void consumirBateria (double minutos) {
      double consumo = minutos * 0.25; //0.25% por minuto
      bateria = bateria - consumo;
      if (bateria < 0) { //para que la bateria nunca sea negativa
          bateria = 0; 
      }
  }
}
