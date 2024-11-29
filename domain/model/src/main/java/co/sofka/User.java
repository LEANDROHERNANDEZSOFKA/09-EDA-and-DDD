package co.sofka;

import co.sofka.events.AccountCreatedEvent;
import co.sofka.events.TransactionCreatedEvent;
import co.sofka.generic.AggregateRoot;
import co.sofka.generic.DomainEvent;
import co.sofka.vo.account.AccountNumber;
import co.sofka.vo.transaction.AmountCost;
import co.sofka.vo.transaction.AmountTransaction;
import co.sofka.vo.transaction.TransactionAccountId;
import co.sofka.vo.transaction.TypeOfTransaction;
import co.sofka.vo.user.*;

import java.util.List;
import java.util.UUID;

public class User extends AggregateRoot<UserId> {

    protected Firstname firstname;
    protected LastName lastName;
    protected Email email;
    protected Password password;
    protected Role role;
    protected Account account;
    protected List<Transaction> transactionList;

    private User(UserId id) {
        super(id);
        subscribe(new UserChange(this));
    }


    public User(Firstname firstname, LastName lastName, Email email, Password password, Role role) {
        super(UserId.of(UUID.randomUUID().toString()));
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        subscribe(new UserChange(this));
    }

    public static User from(UserId id, List<DomainEvent> events) {
        User user = new User(id);
        events.forEach(user::applyEvent);
        return user;
    }


    public void createAccount(Account account) {
        appendChange(new AccountCreatedEvent(account.getAccountNumber().value(), account.getAmount().value(), account.getUserId().value())).apply();
    }


    public void addTransaction(Transaction transaction) {
        appendChange(new TransactionCreatedEvent(
                transaction.accountNumber().value(),
                transaction.amount().value(),
                transaction.amountCost().value(),
                transaction.accountId().value(),
                transaction.type())
        ).apply();
    }
}
