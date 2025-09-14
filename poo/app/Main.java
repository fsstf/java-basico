package poo.app;

import poo.model.Persona;
import poo.factory.PersonaFabrica;
import poo.exception.PersonaNoEncontradaException;
import poo.service.PersonaService;

import java.util.*;

public class Main {
    private static final PersonaService personaService = new PersonaService();
    private static final List<Persona> personas = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static final PersonaFabrica fabrica = new PersonaFabrica();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            try {
                switch (opcion) {
                    case 1 -> agregarPersona();
                    case 2 -> listarPersonas();
                    case 3 -> buscarPersonaPorNombre();
                    case 4 -> mostrarNombres();
                    case 5 -> mostrarMapa();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");


                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
        sc.close();
        personaService.cerrarScanner();

    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gestor de Empleados ===");
        System.out.println("1. Agregar Persona/Empleado/Gerente");
        System.out.println("2. Listar Personas");
        System.out.println("3. Buscar Persona por nombre");
        System.out.println("4. Mostrar nombres únicos");
        System.out.println("5. Mostrar mapa de personas");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarPersona() {
        System.out.println("\n=== Agregar Persona ===");
        System.out.println("Tipo: persona / empleado / gerente");
        String tipo = sc.nextLine();
        personas.add(fabrica.crear(tipo));
        }


    private static void listarPersonas() {
        System.out.println("\n=== Lista de Personas ===");
        personas.forEach(System.out::println);
    }

    private static void buscarPersonaPorNombre() throws PersonaNoEncontradaException {
        Persona encontrada = personaService.buscarPorNombre(personas);
        System.out.println(encontrada);
    }

    public static void mostrarNombres(){
        Set<String> nombres = new HashSet<>();
        for (Persona persona : personas) {
            nombres.add(persona.getNombre());
        }
        System.out.println("Lista de nombres: "+ nombres);
    }

    public static void mostrarMapa(){
        Map<String, Persona> mapa = new HashMap<>();
        for (Persona persona : personas) {
            mapa.put(persona.getNombre(), persona);
        }
        System.out.println("Mapa de personas: "+ mapa);
    }
}
