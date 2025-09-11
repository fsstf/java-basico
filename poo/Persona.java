package poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;

    public Persona(String nombre, String nacionalidad, LocalDate fechaDeNacimiento) {
        setNombre(nombre);
        setFechaDeNacimiento(fechaDeNacimiento);
        setNacionalidad(nacionalidad);
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre Invalido");
        }
            this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException("Nacionalidad Invalido");
        }
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaDeNacimiento() {return fechaDeNacimiento;}

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento == null || fechaDeNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento Invalido");
        }
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public int getEdad(){
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }

    //Metodo Saludar
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre());
    }

    //toString
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + getEdad() + ", nacionalidad='" + nacionalidad + "'}";
    }
    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona p)) return false;
        return Objects.equals(nombre, p.nombre)
                && Objects.equals(fechaDeNacimiento, p.fechaDeNacimiento)
                && Objects.equals(nacionalidad, p.nacionalidad);
    }

    /* equals que prohibe la comparacion de diferentes clases
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona p = (Persona) o;
        return Objects.equals(nombre, p.nombre)
                && Objects.equals(fechaNacimiento, p.fechaNacimiento);
    }
    */

    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaDeNacimiento, nacionalidad);
    }
}


