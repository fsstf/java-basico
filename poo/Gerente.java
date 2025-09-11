package poo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Gerente extends Empleado{
    private BigDecimal bono;

    Gerente(String nombre, String nacionalidad , LocalDate fechaDeNacimiento, BigDecimal sueldo, BigDecimal bono){
        super(nombre,nacionalidad,fechaDeNacimiento,sueldo);
        setBono(bono);
    }

    public BigDecimal getBono() {
        return bono;
    }
    public void setBono(BigDecimal bono) {
        if  (bono == null || bono.signum() < 0) throw  new IllegalArgumentException("Bono invalido");
        this.bono = bono;
    }


    @Override
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre() + " y soy gerente");

    }

    @Override
    public String toString(){
        return "Gerente{nombre='" + getNombre()+ "', edad=" + getEdad() + ", nacionalidad='" + getNacionalidad()
                + "', sueldo" + getSueldo() + ", bono=" + bono + "}";

    }
}
