package poo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Empleado extends Persona{
    private BigDecimal sueldo;

    public Empleado(String nombre, String nacionalidad, LocalDate fechaDeNacimineto, BigDecimal sueldo){
        super(nombre,nacionalidad,fechaDeNacimineto);
        setSueldo(sueldo);
    }

    public  BigDecimal getSueldo() { return sueldo; }

    public void setSueldo(BigDecimal sueldo) {
        if(sueldo == null || sueldo.signum() < 0){
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
