package co.sofka.events;


import co.sofka.generic.DomainEvent;
import co.sofka.vo.transaction.TypeOfTransaction;

import java.math.BigDecimal;

public class TransactionCreatedEvent extends DomainEvent {

    private int number;
    private BigDecimal amount;
    private BigDecimal amountCost;
    private String customerId;
    private TypeOfTransaction type;


    public TransactionCreatedEvent() {
        super( "Transaction");
    }

    public TransactionCreatedEvent(int number,BigDecimal amount, BigDecimal amountCost, String customerId, TypeOfTransaction type) {
        super("transaction");
        this.number = number;
        this.amount = amount;
        this.amountCost = amountCost;
        this.customerId = customerId;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountCost() {
        return amountCost;
    }

    public void setAmountCost(BigDecimal amountCost) {
        this.amountCost = amountCost;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public TypeOfTransaction getTypeTrans() {
        return type;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }
}
