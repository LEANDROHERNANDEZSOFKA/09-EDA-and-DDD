package co.sofka.vo.user;

import co.sofka.generic.ValueObject;

public class LastName implements ValueObject<String> {

    private final String lastName;

    public LastName(String lastName) {
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    @Override
    public String value(){return this.lastName;}
}
