package poo.strategy;

import java.math.BigDecimal;

public interface CalcularPago {
    BigDecimal calcularPago(BigDecimal sueldo,BigDecimal bono);
}
