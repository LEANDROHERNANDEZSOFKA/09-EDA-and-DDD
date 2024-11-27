package co.sofka.vo.account;

import co.sofka.generic.ValueObject;

import java.math.BigDecimal;

public class Amount implements ValueObject<BigDecimal> {

    private final BigDecimal amount;

    public Amount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal value() {
        return this.amount;
    }
}
