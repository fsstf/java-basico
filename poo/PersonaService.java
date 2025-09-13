package poo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
        BigDecimal sueldo = new BigDecimal(sc.nextLine());
        return new Empleado(p.getNombre(), p.getNacionalidad(), p.getFechaDeNacimiento(), sueldo);
    }

    public Gerente crearGerente() {
        Empleado e = crearEmpleado();
        System.out.print("Bono del gerente: ");
        BigDecimal bono = new BigDecimal(sc.nextLine());
        return new Gerente(e.getNombre(),e.getNacionalidad(),e.getFechaDeNacimiento(),e.getSueldo(),bono);
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

    public Persona buscarPorNombre( List<Persona> lista) throws PersonaNoEncontradaException {
        String nombre = pedirNombre();
        return lista.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new PersonaNoEncontradaException("No se encontro persona con el nombre: " + nombre));
    }

    public String pedirNombre(){
        System.out.println("Ingrese el nombre del persona: ");
        return sc.nextLine();
    }

    public void cerrarScanner() {
        sc.close();
    }
}


