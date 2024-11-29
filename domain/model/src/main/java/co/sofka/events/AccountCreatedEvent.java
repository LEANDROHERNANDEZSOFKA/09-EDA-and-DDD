package co.sofka.events;

import co.sofka.generic.DomainEvent;

import java.math.BigDecimal;
import java.time.Instant;

public class AccountCreatedEvent extends DomainEvent {

    private String id;
    private int number;
    private BigDecimal amount;
    private String customerId;
    private final Instant createdAt;

    public AccountCreatedEvent() {
        super("Account");
        createdAt = Instant.now();
    }
    public AccountCreatedEvent(int number, BigDecimal amount, String customerId) {
        super("Account");
        this.createdAt = Instant.now();
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
