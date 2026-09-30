
/**
 *La clase Persona sive como clase base para representar a 
 *cualquier persona relacionada con el sistema, ya sea un 
 *cliente o un trabajador.
 *
 * @author (Yamina Abjil) 
 */
public class Persona 
{
    private String nombre;
    private String dni;
    private double telefono;
    
    //constructor
    public Persona (String nombre, String dni, double telefono){
        this.nombre=nombre;
        this.dni=dni;
        this.telefono=telefono;
    }
    
    
    public String getDni() {
        return this.dni;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    
    public double getTelefono(){
        return this.telefono;
    }
    public void setTelefono(double telefono) {
        this.telefono=telefono;
    }
    
    //imprimir informacion de persona
    public void imprimirPersona(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("DNI: " + this.dni);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("------------------------");
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

