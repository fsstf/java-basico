package poo;

import java.time.LocalDate;

public class Empleado extends Persona{
    private double sueldo;
    public Empleado(String nombre, String nacionalidad, LocalDate fechaDeNacimineto, double sueldo){
        super(nombre,nacionalidad,fechaDeNacimineto);
        this.sueldo=sueldo;
    }
    public  double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) {
        if(sueldo<0){
            throw new IllegalArgumentException("Sueldo Invalido");
        }
        this.sueldo = sueldo;
    }
    @Override
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre()+ " y mi sueldo es de: "+ sueldo);
    }

    @Override
    public String toString() {
        return "Empleado{nombre='" + getNombre() + "', edad=" + getEdad() + ", nacionalidad: '"+ getNacionalidad() + "', sueldo: " + sueldo + "}";
    }

}
