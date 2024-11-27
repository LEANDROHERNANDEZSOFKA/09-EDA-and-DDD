package co.sofka.vo.user;

import co.sofka.generic.ValueObject;

public class Firstname implements ValueObject<String> {

    private final String firstname;

    public Firstname(String firstname) {
        if(firstname.isEmpty()){
            throw new IllegalArgumentException("Firstname must have at least one character");
        }
        this.firstname = firstname;
    }

    @Override
    public String value(){return this.firstname;}
}
