package co.sofka.vo.transaction;

import co.sofka.generic.Identity;

public class Transactionid extends Identity {

    public Transactionid() {

    }

    private Transactionid(String uuid){super(uuid);}

    public static Transactionid of(String uuid){return new Transactionid(uuid);};
}
