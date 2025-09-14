package poo.model;

import java.time.LocalDate;

public class Persona extends PersonaBase {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;

    public Persona(String nombre, String nacionalidad, LocalDate fechaDeNacimiento) {
        super(nombre,nacionalidad,fechaDeNacimiento);
    }

    @Override
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


