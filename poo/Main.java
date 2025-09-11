package poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();
        LocalDate fechaFer = LocalDate.parse("2000-11-21");
        LocalDate fechaSara = LocalDate.parse("2002-10-04");

        Persona p = new Persona("Fernando","Mexicana",fechaFer);
        Persona e = new Empleado("Sara","Mexicana",fechaSara,2500.45);
        Persona i = service.crearPersona();

        List<Persona> personas = new ArrayList<>();
        personas.add(p);
        personas.add(e);
        personas.add(i);

        for(Persona x : personas){
            x.saludar();
            System.out.println(x);
        }
    }
}
