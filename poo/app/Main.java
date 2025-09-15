package poo.app;

import poo.model.Empleado;
import poo.dao.EmpleadoDAO;
import poo.model.Persona;
import poo.factory.PersonaFabrica;
import poo.service.PersonaService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
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
                    case 1 -> agregarEmpleado();
                    case 2 -> listarEmpleados();
                    case 3 -> buscarEmpleadoPorId();
                    case 4 -> actualizarSueldo();
                    case 5 -> eliminarEmpleado();
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
        System.out.println("\n=== Gestor de Empleados (BD) ===");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Buscar empleado por ID");
        System.out.println("4. Actualizar sueldo");
        System.out.println("5. Eliminar empleado");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarEmpleado() {
        System.out.println("Nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Nacionalidad del empleado: ");
        String nacionalidad = sc.nextLine();
        System.out.println("Fecha de nacimiento del empleado(YYYY-MM-DD): ");
        LocalDate fecha =  LocalDate.parse(sc.nextLine());
        System.out.println("Sueldo del empleado: ");
        BigDecimal sueldo = new BigDecimal(sc.nextLine());

        Empleado e = new Empleado(nombre, nacionalidad, fecha, sueldo);
        empleadoDAO.insertar(e);
    }

    private static void listarEmpleados() {
        System.out.println("\n==== Lista de empleados ====");
        empleadoDAO.listar().forEach(System.out::println);
    }

    private static void buscarEmpleadoPorId() {
        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());
        var empleado = empleadoDAO.buscarPorId(id);
        if (empleado != null) {
            System.out.println("🔍 Encontrado: " + empleado);
        } else {
            System.out.println("⚠️ No existe empleado con ID " + id);
        }
    }

    private static void actualizarSueldo() {
        System.out.print("ID del empleado: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo sueldo: ");
        BigDecimal nuevoSueldo = new BigDecimal(sc.nextLine());
        empleadoDAO.actualizarSueldo(id, nuevoSueldo);
    }

    private static void eliminarEmpleado() {
        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        empleadoDAO.eliminar(id);
    }
}
