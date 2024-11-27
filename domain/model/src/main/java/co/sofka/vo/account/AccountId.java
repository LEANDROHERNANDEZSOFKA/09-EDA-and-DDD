package co.sofka.vo.account;

import co.sofka.generic.Identity;

public class AccountId extends Identity {

    public AccountId() {

    }

    private AccountId(String uuuid){
        super(uuuid);
    }

    public static AccountId of(String uuuid){
        return new AccountId(uuuid);
    }

}
