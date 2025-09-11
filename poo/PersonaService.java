package poo;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonaService {
    private final Scanner sc = new Scanner(System.in);

    public Persona crearPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();
        LocalDate fechaDeNacimiento = pedirFechaDeNacimiento();
        return new Persona(nombre, nacionalidad, fechaDeNacimiento);
    }

    public Empleado crearEmpleado() {
        Persona p = crearPersona();
        System.out.print("Sueldo del empleado: ");
        double sueldo = Double.parseDouble(sc.nextLine());
        return new Empleado(p.getNombre(), p.getNacionalidad(), p.getFechaDeNacimiento(), sueldo);
    }

    private LocalDate pedirFechaDeNacimiento() {
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Formato inválido, intente nuevamente");
            }
        }
    }

    public void cerrarScanner() {
        sc.close();
    }
}
