package poo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();

        Persona p = new Persona("Fernando", "Mexicana", LocalDate.parse("2000-11-21"));
        Empleado e = new Empleado("Sara", "Mexicana", LocalDate.parse("2002-10-04"),new BigDecimal("4335.3432"));
        Gerente g = new Gerente("Sheyla", "Mexicana", LocalDate.parse("1999-11-24"), new BigDecimal("63235.9553"), new BigDecimal("43235.3243"));
        //Persona i = service.crearPersona();

        List<Persona> personas = new ArrayList<>();
        personas.add(p);
        personas.add(e);
        personas.add(g);
        //personas.add(i)

        for(Persona x : personas){
            x.saludar();
            System.out.println(x);
        }

        System.out.println(service.buscarPorNombre(personas));

        service.cerrarScanner();
    }
}
