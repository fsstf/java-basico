package poo.model;

import poo.strategy.CalcularPago;
import poo.strategy.PagoGerente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Gerente extends Empleado implements Pagable {

    private final BigDecimal bono;

    public Gerente(String nombre, String nacionalidad , LocalDate fechaDeNacimiento, BigDecimal sueldo, BigDecimal bono){
        this(nombre,nacionalidad,fechaDeNacimiento,sueldo,bono,new PagoGerente());
    }

    public Gerente(String nombre, String nacionalidad, LocalDate fecha,
                   BigDecimal sueldo, BigDecimal bono, CalcularPago calcularPago) {
        super(nombre, nacionalidad, fecha, sueldo, calcularPago);
        if (bono == null || bono.signum() < 0) {
            throw new IllegalArgumentException("Bono inválido");
        }
        this.bono = bono;
    }

    public BigDecimal getBono() { return bono; }

    @Override
    public void saludar(){ System.out.println("Hola mi nombre es "+ getNombre() + " y soy gerente"); }

    @Override
    public String toString(){ return super.toString() + " bono=" + getBono(); }

    @Override
    public BigDecimal calcularPago() {
        return getCalcularPago().calcularPago(getSueldo(), bono);
    }
}
