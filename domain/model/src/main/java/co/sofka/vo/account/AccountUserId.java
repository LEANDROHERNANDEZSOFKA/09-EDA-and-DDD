package co.sofka.vo.account;

import co.sofka.generic.ValueObject;

public class AccountUserId implements ValueObject<String> {

    private final String userId;

    public AccountUserId(String userId) {
        if(userId.isEmpty()){
            throw new IllegalArgumentException("UserId value is empty");
        }
        this.userId = userId;
    }

    @Override
    public String value() {
        return this.userId;
    }
}
