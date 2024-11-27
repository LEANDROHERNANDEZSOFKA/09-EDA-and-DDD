package co.sofka.vo.account;

import co.sofka.generic.ValueObject;

public class AccountNumber implements ValueObject<Integer> {

    private final Integer number;

    public AccountNumber(Integer number) {
        if(number == null || number <= 0){
            throw new IllegalArgumentException("Number cannot be null or less than zero");
        }
        this.number = number;
    }


    @Override
    public Integer value() {
        return this.number;
    }
}
