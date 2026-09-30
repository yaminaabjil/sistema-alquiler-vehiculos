
/**
 * Esta clase sirve para representar un punto dentro del mapa
 * de la ciudad, para encontrar nuestras bases y vehiculos.
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;


public class Ubicacion
{
   public static ArrayList<Ubicacion> bases = new ArrayList<>();
   public static ArrayList<Ubicacion> basesEnReparacion = new ArrayList<>();
   private boolean ocupada = false;
   
   private double x; //coordenada en el eje x
   private double y; //coordenada en el eje y
   
   //constructor
   public Ubicacion(double x, double y) {
       this.x = x;
       this.y = y;
   }
   
   public void ocuparPlaza() {
       this.ocupada = true;
   }
   public void liberarPlaza() {
       this.ocupada= false;
   }
   public boolean estaOcupada() {
       return ocupada;
   }
   public double getX() {
       return x;
   }
   public double getY() {
       return y;
   }
   public static ArrayList<Ubicacion> getBasesEnReparacion() {
        return basesEnReparacion;
   }
   public static ArrayList<Ubicacion> getBases() {
        return bases;
   }
   
   //Metodo para calcular distancia de un punto a otro
   public double distanciaAB (Ubicacion otra) {
       double dx = this.x - otra.x;
       double dy = this.y - otra.y;
       
       return Math.sqrt(dx * dx + dy * dy);
   }
   
   //para mostrar la ubicacion en texto 
   public String toString() {
       return "(" + x + ", " + y + ")";
   }
   
   //metodo para agregar una nueva base
   public static void agregarBase (double x, double y) {
       Ubicacion nuevaBase = new Ubicacion(x,y);
       bases.add(nuevaBase);
       System.out.println("Base añadida en coordenadas: " + nuevaBase);
   } 
   //metodo para eliminar una base
   public static void eliminarBase (Ubicacion base) {
       basesEnReparacion.remove(base);
       bases.remove(base);
       System.out.println("Base eliminada en coordenadas: " + base);
   }
   
   //metodo para reportar fallo en una base
   public static void reportarFalloBase(Ubicacion base) {
       if (bases.contains(base) && !basesEnReparacion.contains(base)) {
           basesEnReparacion.add(base);
           System.out.println("Base reportada como averiada: " + base);
       } else {
           System.out.println("Base no encontrada o ya en reparacion.");
       }          
   }
   
   //metodo para verificar que la base esta disponible 
   public boolean estaDisponible (ArrayList<Ubicacion> basesEnReparacion){
       return !basesEnReparacion.contains(this) && !ocupada;
   }
   
   //metodo para marcar una base como ya reparada
   public static void repararBase(Ubicacion base) {
       basesEnReparacion.remove(base);
       System.out.println("La base en " + base + " ha sido reparada");
  }
  
  //metodo para mostrar todas las bases
  public static void mostrarBases() {
       System.out.println("══✿══❪ Lista de bases ❫══✿══");
       for (int i=0; i < bases.size(); i++){
           Ubicacion b = bases.get(i);
           String estado = "";
           if (basesEnReparacion.contains(b)) {
               estado = " (en reparacion)";
           }
           System.out.println("- " + b + estado);
       }
       System.out.println("✄-----------------------");
  }
}
