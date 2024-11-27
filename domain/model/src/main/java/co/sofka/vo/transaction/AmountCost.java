package co.sofka.vo.transaction;

import co.sofka.generic.ValueObject;

import java.math.BigDecimal;

public class AmountCost implements ValueObject<BigDecimal> {

    private final BigDecimal amountCost;

    public AmountCost(BigDecimal amountCost) {
        this.amountCost = amountCost;
    }

    @Override
    public BigDecimal value() {
        return this.amountCost;
    }

}
