package poo.factory;

import poo.model.Empleado;
import poo.model.Gerente;
import poo.model.Persona;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonaFabrica {
    private static final Scanner sc = new Scanner(System.in);

    public static Persona crear(String tipo) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        switch (tipo.toLowerCase()) {
            case "empleado" -> {
                System.out.print("Sueldo: ");
                BigDecimal sueldo = new BigDecimal(sc.nextLine());
                return new Empleado(nombre, nacionalidad, fecha, sueldo);
            }
            case "gerente" -> {
                System.out.print("Sueldo: ");
                BigDecimal sueldo = new BigDecimal(sc.nextLine());
                System.out.print("Bono: ");
                BigDecimal bono = new BigDecimal(sc.nextLine());
                return new Gerente(nombre, nacionalidad, fecha, sueldo, bono);
            }
            default -> {
                return new Persona(nombre, nacionalidad, fecha);
            }
        }
    }
}
