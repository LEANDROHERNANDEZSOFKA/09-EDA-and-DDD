package co.sofka.vo.account;

import co.sofka.generic.ValueObject;

import java.time.LocalDate;

public class CreatedAt implements ValueObject<LocalDate> {

    private final LocalDate createdAt;

    public CreatedAt() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public LocalDate value() {
        return this.createdAt;
    }
}
