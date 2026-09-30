
/**
 * En esta clase se gestiona todo lo relacionado con los clientes
 * y los trabajadores.
 * 
 * @author (Yamina Abjil) 
 */

import java.util.ArrayList;

public class GestionPersonas 
{
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Trabajadores> trabajadores = new ArrayList<>();   
    
    public ArrayList<Cliente> getClientes() {
     return clientes;
    }
    public ArrayList<Trabajadores> getTrabajadores() {
     return trabajadores;
    }
    
    //dar de alta de clientes
    public void agregarCliente (Cliente c) {
        clientes.add(c);
        System.out.println ("Cliente agregado: " + c.getNombre());
    }
    //dar de baja de clientes 
    public void eliminarCliente ( Cliente c) {
        clientes.remove(c);
        System.out.println("Cliente eliminado: " + c.getNombre());
    }
    //modificar datos de clientes
    public void modificarUsuario(String dni, String nuevoNombre, double nuevoTelefono, String nuevoTipoCliente) {
       boolean encontrado = false; 
       for (int i=0; i < clientes.size(); i++) { //buscar cliente 
           Cliente cliente = clientes.get(i); 
           if (cliente.getDni().equals(dni)) { //si encontramos el cliente con el dni indicado
           cliente.setNombre(nuevoNombre);
           cliente.setTelefono(nuevoTelefono);
           cliente.setTipoCliente(nuevoTipoCliente);
           System.out.println("Datos del cliente con DNI: " + dni + " modificados correctamente.");
           encontrado = true ;
           break;
           } else  {
           System.out.println("Cliente con DNI " + dni + "no encontrado.");
           }
       }       
    }
    //listar los clientes
    public void listaClientes () {
        if (clientes.isEmpty()) {
            System.out.println("No usuarios registrados.");
        } else {
        System.out.println ("══✿══❪ Listado de clientes ❫══✿══ ");
        for (int i = 0; i < clientes.size(); i ++ ) {
            Cliente c = clientes.get(i);
            c.imprimirCliente();
        }
        System.out.println("✄-----------------------");
        }
    }

    //dar de alta de trabajador
    public void agregarTrabajador (Trabajadores t) {
        trabajadores.add(t);
        System.out.println ("Trabajador agregado: " + t.getNombre());
    }
    //dar de baja de trabajadores
    public void eliminarTrabajador (Trabajadores t) {
        trabajadores.add(t);
        System.out.println ("Trabajador eliminado: " + t.getNombre());
    }
    //listar los trabajadores
    public void listaTrabajadores () {
        if (trabajadores.isEmpty()) {
            System.out.println("No trabajadores registrados.");
        } else {
        System.out.println ("══✿══❪ Listado de trabajadores ❫══✿══");
        for (int i = 0; i < trabajadores.size(); i ++ ) {
            Trabajadores t = trabajadores.get(i);
            t.imprimirTrabajador();
        }
        System.out.println("✄-----------------------");
    }
    }
}
