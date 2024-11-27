package co.sofka;

import co.sofka.generic.AggregateRoot;
import co.sofka.vo.user.*;

import java.util.ArrayList;
import java.util.List;

public class User extends AggregateRoot<UserId> {

    protected Firstname firstname;
    protected LastName lastName;
    protected Email email;
    protected Password password;
    protected Role role;
    protected Account account;
    protected List<Transactions>transactionList;

    public User(UserId id) {
        super(id);
    }


}
