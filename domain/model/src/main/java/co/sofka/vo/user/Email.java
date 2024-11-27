package co.sofka.vo.user;

import co.sofka.generic.ValueObject;

import java.util.regex.Pattern;

public class Email implements ValueObject<String> {

    private final String email;


    public Email(String email) {
        if(!validateEmail(email)){
            throw new IllegalArgumentException("Invalidate email");
        }

        this.email = email;
    }

    public Boolean validateEmail(String email) {
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regexEmail, email);
    }

    @Override
    public String value(){
        return this.email;
    }
}
