package poo.strategy;

import java.math.BigDecimal;

public class PagoEmpleado implements CalcularPago {

    @Override
    public BigDecimal calcularPago(BigDecimal sueldo, BigDecimal bono) {
        return sueldo;
    }
}
