package poo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PersonaNoEncontradaException {
        PersonaService service = new PersonaService();

        try {
            Empleado et = new Empleado("Sara", "Mexicana", LocalDate.parse("2002-10-04"), new BigDecimal("10"));
        }catch (IllegalArgumentException e){
            System.out.println("Error: "  + e.getMessage());
        }

        Persona p = new Persona("Fernando", "Mexicana", LocalDate.parse("2000-11-21"));

        Empleado e = new Empleado("Azucena","MX",LocalDate.of(2005,11,10),new BigDecimal("20"));

        Gerente g = new Gerente("Sheyla", "Mexicana", LocalDate.parse("1999-11-24"), new BigDecimal("63235.9553"), new BigDecimal("43235.3243"));

        List<Persona> personas = new ArrayList<>();
        personas.add(p);
        personas.add(g);
        personas.add(e);

        for(Persona x : personas){
            x.saludar();
            System.out.println(x);
        }

        System.out.println(service.buscarPorNombre(personas));

        service.cerrarScanner();
    }
}
