package co.sofka.vo.transaction;

import co.sofka.generic.ValueObject;

import java.math.BigDecimal;

public class Amount implements ValueObject<BigDecimal> {

    private final BigDecimal amount;

    public Amount(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.amount = amount;
    }

    @Override
    public BigDecimal value() {
        return this.amount;
    }
}
