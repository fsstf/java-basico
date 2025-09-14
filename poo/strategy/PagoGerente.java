package poo.strategy;

import java.math.BigDecimal;

public class PagoGerente implements CalcularPago {
    @Override
    public BigDecimal calcularPago(BigDecimal sueldo, BigDecimal bono) {
        return sueldo.add(bono);
    }
}
