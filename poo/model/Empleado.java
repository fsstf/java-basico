package poo.model;

import poo.strategy.CalcularPago;
import poo.strategy.PagoEmpleado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona implements Pagable {
    private final BigDecimal sueldo;
    private final CalcularPago calcularPago;

    public Empleado(String nombre, String nacionalidad, LocalDate fechaDeNacimineto, BigDecimal sueldo){
        this(nombre,nacionalidad,fechaDeNacimineto,sueldo,new PagoEmpleado());
    }

    public Empleado(String nombre, String nacionalidad, LocalDate fechaDeNacimiento,
                    BigDecimal sueldo, CalcularPago calcularPago) {
        super(nombre, nacionalidad, fechaDeNacimiento);
        if (sueldo == null || sueldo.signum() < 0) {
            throw new IllegalArgumentException("Sueldo inválido");
        }
        this.sueldo = sueldo;
        this.calcularPago = Objects.requireNonNull(calcularPago, "EstrategiaPago no puede ser null");
    }
    public  BigDecimal getSueldo() { return sueldo; }

    @Override
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre()+ " y mi sueldo es de: "+ sueldo);
    }

    @Override
    public String toString() {
        return super.toString() + " sueldo=: " + sueldo;
    }

    @Override
    public BigDecimal calcularPago() {
        return calcularPago.calcularPago(sueldo, BigDecimal.ZERO);
    }

    protected CalcularPago getCalcularPago() {
        return this.calcularPago;
    }
}
