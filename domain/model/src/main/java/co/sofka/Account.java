package co.sofka;

import co.sofka.generic.Entity;
import co.sofka.vo.account.*;

public class Account extends Entity<AccountId> {

    private final AccountNumber accountNumber;
    private final Amount amount;
    private final AccountUserId accountUserId;
    private final CreatedAt createdAt;
    private final IsDeleted isDeleted;

    private Account(AccountNumber accountNumber, Amount amount, AccountUserId accountUserId, CreatedAt createdAt, IsDeleted isDeleted) {
        super(new AccountId());
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.accountUserId = accountUserId;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public AccountUserId getUserId() {
        return accountUserId;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public IsDeleted getIsDeleted() {
        return isDeleted;
    }

    public static class Builder {

        private AccountNumber accountNumber;
        private Amount amount;
        private AccountUserId accountUserId;
        private CreatedAt createdAt;
        private IsDeleted isDeleted;

        public Builder accountNumber(AccountNumber accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder amount(Amount amount) {
            this.amount = amount;
            return this;
        }

        public Builder userId(AccountUserId accountUserId) {
            this.accountUserId = accountUserId;
            return this;
        }

        public Builder createdAt(CreatedAt createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setIsDeleted(IsDeleted isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        public Account build() {
            return new Account(accountNumber, amount, accountUserId, createdAt, isDeleted);
        }
    }
}
