
/**
 * Write a description of interface Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Movilidad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Inicialización de Gestores
        GestionPersonas gestionPersonas = new GestionPersonas();
        GestionVehiculos gestionVehiculos = new GestionVehiculos();
        GestionAlquiler gestionAlquiler = new GestionAlquiler();
        
        // 2. Creación de Personal
        Admin admin = new Admin("Admin1", "12345678A", 600000000, "ADM-01");
        Mecanico mecanico = new Mecanico("Paco", "87654321B", 600111222, "MEC-01");
        Mantenimiento mant = new Mantenimiento("Luis", "11223344C", 600333444, "MAN-01");
        
        gestionPersonas.agregarTrabajador(admin);
        gestionPersonas.agregarTrabajador(mecanico);
        gestionPersonas.agregarTrabajador(mant);
        
        // 3. Creación de Bases y Vehículos
        Ubicacion.agregarBase(10, 10);
        Ubicacion.agregarBase(50, 50);
        Ubicacion baseOrigen = Ubicacion.getBases().get(0);
        Ubicacion baseDestino = Ubicacion.getBases().get(1);
        
        Bicicleta bici = new Bicicleta("BIC-001", 100, baseOrigen, false, 0.15);
        Patinete patin = new Patinete("PAT-001", 15, baseOrigen, false, 0.20); // Batería baja a propósito
        gestionVehiculos.agregarVehiculo(bici);
        gestionVehiculos.agregarVehiculo(patin);

        // 4. Creación de Cliente
        UsuarioEstandar clientePrueba = new UsuarioEstandar("Carlos", "11122233C", 654321987, 50.0){};
        gestionPersonas.agregarCliente(clientePrueba);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== SISTEMA DE MOVILIDAD SOSTENIBLE =====");
            System.out.println("1. Menú Administrador");
            System.out.println("2. Menú Cliente (Carlos)");
            System.out.println("3. Menú Trabajadores (Mantenimiento / Mecánico)");
            System.out.println("4. Salir");
            System.out.print("Elige un perfil: ");
            
            int opcionUsuario = sc.nextInt();
            sc.nextLine(); 

            switch (opcionUsuario) {
                case 1: // ================= MENÚ ADMIN =================
                    boolean salirAdmin = false;
                    while (!salirAdmin) {
                        System.out.println("\n--- MENÚ ADMIN ---");
                        System.out.println("1. Ver lista de clientes");
                        System.out.println("2. Ver estado de la flota (Baterías)");
                        System.out.println("3. Evaluar ascensos a Premium");
                        System.out.println("4. Ver todos los avisos de avería/batería");
                        System.out.println("5. Asignar tareas a los trabajadores");
                        System.out.println("6. Volver");
                        System.out.print("Opción: ");
                        
                        int opAdmin = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opAdmin) {
                            case 1:
                                admin.verClientes(gestionPersonas.getClientes(), gestionPersonas);
                                break;
                            case 2:
                                admin.visualizarEstadoBateria(gestionVehiculos);
                                break;
                            case 3:
                                System.out.println("Evaluando cliente Carlos...");
                                admin.serPremium(clientePrueba);
                                break;
                            case 4:
                                admin.verAvisos();
                                break;
                            case 5:
                                admin.asignarTareas(mecanico, mant);
                                System.out.println("Tareas asignadas correctamente.");
                                break;
                            case 6:
                                salirAdmin = true;
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                        }
                    }
                    break;
                    
                case 2: // ================= MENÚ CLIENTE =================
                    boolean salirCliente = false;
                    while(!salirCliente) {
                        System.out.println("\n--- ACCESO CLIENTE: " + clientePrueba.getNombre() + " ---");
                        System.out.println("1. Iniciar alquiler (Usar BIC-001)");
                        System.out.println("2. Finalizar alquiler actual");
                        System.out.println("3. Ver mi historial de viajes");
                        System.out.println("4. Reportar avería en vehículo");
                        System.out.println("5. Reportar fallo de batería");
                        System.out.println("6. Volver");
                        System.out.print("Opción: ");
                        
                        int opCliente = sc.nextInt();
                        sc.nextLine();
                        
                        switch(opCliente) {
                            case 1:
                                gestionAlquiler.iniciarAlquiler(clientePrueba, bici, baseOrigen);
                                break;
                            case 2:
                                if (clientePrueba.getHistorialViajes().isEmpty()) {
                                    System.out.println("No tienes viajes activos.");
                                } else {
                                    // Obtenemos el último viaje del historial
                                    int ultimo = clientePrueba.getHistorialViajes().size() - 1;
                                    gestionAlquiler.finalizarAlquiler(clientePrueba.getHistorialViajes().get(ultimo), baseDestino);
                                }
                                break;
                            case 3:
                                clientePrueba.mostrarHistorial();
                                break;
                            case 4:
                                clientePrueba.reportarFalloVehiculo(bici, "Freno roto", "reparacion", clientePrueba);
                                break;
                            case 5:
                                clientePrueba.reportarFalloVehiculo(patin, "Batería baja", "bateria", clientePrueba);
                                break;
                            case 6:
                                salirCliente = true;
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                        }
                    }
                    break;

                case 3: // ================= MENÚ TRABAJADORES =================
                    boolean salirTrabajador = false;
                    while(!salirTrabajador) {
                        System.out.println("\n--- MENÚ TRABAJADORES ---");
                        System.out.println("1. Ver avisos del Mecánico");
                        System.out.println("2. Ver avisos de Mantenimiento");
                        System.out.println("3. Mecánico: Reparar Vehículo (Simulación)");
                        System.out.println("4. Mantenimiento: Recargar Vehículo (Simulación)");
                        System.out.println("5. Volver");
                        System.out.print("Opción: ");
                        
                        int opTrabajador = sc.nextInt();
                        sc.nextLine();
                        
                        switch(opTrabajador) {
                            case 1:
                                mecanico.mostrarAvisos();
                                break;
                            case 2:
                                mant.mostrarAvisos();
                                break;
                            case 3:
                                mecanico.completarReparacion(bici, "Vehiculo BIC-001 - Freno roto (Cliente: Carlos)", 25.0, clientePrueba);
                                break;
                            case 4:
                                mant.recargarVehiculo(patin);
                                break;
                            case 5:
                                salirTrabajador = true;
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                        }
                    }
                    break;

                case 4: // ================= SALIR =================
                    salir = true;
                    System.out.println("Cerrando el sistema. ¡Buen trabajo con el código!");
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}