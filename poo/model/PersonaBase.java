package poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

abstract class PersonaBase {
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaDeNacimiento;

    public PersonaBase(String nombre, String nacionalidad, LocalDate fechaDeNacimiento) {
    setNombre(nombre);
    setNacionalidad(nacionalidad);
    setFechaDeNacimiento(fechaDeNacimiento);
    }

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
            throw new IllegalArgumentException("Nacionalidad Inválida");
        }
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento == null || fechaDeNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento Invalido");
        }
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad(){
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public abstract void saludar();

    @Override
    public String toString() {
        return "nombre='" + nombre + "', edad=" + getEdad() + ", nacionalidad='" + nacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonaBase p)) return false;
        return Objects.equals(nombre, p.nombre)
                && Objects.equals(fechaDeNacimiento, p.fechaDeNacimiento)
                && Objects.equals(nacionalidad, p.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaDeNacimiento, nacionalidad);
    }

}
