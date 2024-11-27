package co.sofka.vo.user;

import co.sofka.generic.ValueObject;

public class Password implements ValueObject<String> {

    private final String password;

    public Password(String password) {
        if(password.length() < 6 ){
            throw new IllegalArgumentException("Password should be at least 6 characters and contain at least 1 special character");
        }

        this.password=password;
    }

    public boolean containSpecialCharacters(String password) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~\\";

        for (char c : specialCharacters.toCharArray()) {
            if(password.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String value(){
        return this.password;
    }

}
