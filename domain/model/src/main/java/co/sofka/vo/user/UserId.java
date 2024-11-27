package co.sofka.vo.user;

import co.sofka.generic.Identity;

public class UserId extends Identity {

    public UserId() {}

    private UserId(String uuid){super(uuid);}

    public static UserId of(String uuid){
        return new UserId(uuid);
    }
}
