
/**
 *Esta es la subclase Moto heredada de la clase Vehiculo
 *que representa uno de los 3 vehiculos que se pueden alquilar
 *en el sistema, que es la moto 
 *
 * @author (Yamina Abjil) 
 */
public abstract class Moto extends Vehiculo
{
   public Moto (String matricula, double bateria, Ubicacion ubicacion, boolean reservado, double tarifa) {
        super (matricula, bateria, ubicacion, reservado, tarifa);
  }
    
  //verificar la ubicacion de la moto
  public void mover(Ubicacion destino, int limiteX, int limiteY) {
      //verifica que este dentro dde los limites de la ciudad
      if (destino.getX() >= 0 && destino.getX() <= limiteX && destino.getY() >= 0 && destino.getY() <=limiteY) {
          this.ubicacion = destino; //actualiza la ubicacion
      } else {
          System.out.println("ERROR: La moto no puede salir de la ciudad");
      }
  }
  
  //metodo para mostrar el tipo de vehiculo
  public String getTipo() {
      return "Moto";
  }
  
  //Metodo para mostrar la informacion de la moto
  public void infoMoto() {
    System.out.println("Moto " + this.matricula);
    System.out.println("Batería: " + this.bateria + "%");
    System.out.println("Averiada: " + this.averiado);
    System.out.println("Ubicacion: " + this.ubicacion);
    System.out.println("------------------------");
  }
  
}
