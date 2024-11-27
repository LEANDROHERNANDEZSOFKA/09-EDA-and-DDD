package co.sofka.vo.account;

import co.sofka.generic.ValueObject;

public class IsDeleted implements ValueObject<Boolean> {

    private final Boolean isDeleted;

    public IsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public Boolean value() {
        return this.isDeleted;
    }
}
