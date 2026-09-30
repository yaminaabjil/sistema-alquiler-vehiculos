
/**
 * Representar los trabajadores del sistema. Aqui hemos
 * agregado todos los metodos comunes entre los 3 trabajadores
 * 
 * @author (Yamina Abjil) 
 */
public class Trabajadores extends Persona
{
  private String idEmpleado;
  private String puesto;
  
  //constructor
  public Trabajadores (String nombre, String dni, double telefono, String idEmpleado, String puesto) {
      super(nombre, dni, telefono);
      this.idEmpleado=idEmpleado;
      this.puesto=puesto;
  }
  
  public String getIdEmpleado () {
      return idEmpleado;
  }
  public String getPuesto() {
      return puesto;
  }
  public void setPuesto (String puesto) {
      this.puesto=puesto;
  }
  
  public void imprimirTrabajador () {
      super.imprimirPersona();
      System.out.println("ID Empleado: " + idEmpleado);
      System.out.println("Puesto: " + puesto);
  }
}
