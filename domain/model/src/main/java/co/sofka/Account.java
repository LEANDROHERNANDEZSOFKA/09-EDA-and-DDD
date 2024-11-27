package co.sofka;

import co.sofka.generic.Entity;
import co.sofka.vo.account.*;

public class Account extends Entity<AccountId> {

    private final AccountNumber accountNumber;
    private final Amount amount;
    private final UserId userId;
    private final CreatedAt createdAt;
    private final IsDeleted isDeleted;

    public Account(AccountId id, AccountNumber accountNumber, Amount amount, UserId userId, CreatedAt createdAt, IsDeleted isDeleted) {
        super(id);
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.userId = userId;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public AccountNumber accountNumber() {
        return this.accountNumber;
    }

    public Amount amount() {
        return this.amount;
    }

    public UserId userId() {
        return this.userId;
    }

    public CreatedAt createdAt() {
        return this.createdAt;
    }

    public IsDeleted isDeleted() {
        return this.isDeleted;
    }
}
