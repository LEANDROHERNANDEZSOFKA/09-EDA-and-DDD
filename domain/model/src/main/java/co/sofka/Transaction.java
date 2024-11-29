package co.sofka;

import co.sofka.generic.Entity;
import co.sofka.vo.account.AccountNumber;
import co.sofka.vo.transaction.*;

import java.time.Instant;

public class Transaction extends Entity<Transactionid> {


    private final AccountNumber accountNumber;
    private final AmountTransaction amountTransaction;
    private final AmountCost amountCost;
    private final TypeOfTransaction type;
    private final Instant timestamp;
    private final TransactionAccountId transactionAccountId;

    private Transaction(AccountNumber accountNumber, AmountTransaction amountTransaction, AmountCost amountCost, TypeOfTransaction type, Instant timestamp, TransactionAccountId transactionAccountId) {
        super(new Transactionid());
        this.accountNumber = accountNumber;
        this.amountTransaction = amountTransaction;
        this.amountCost = amountCost;
        this.type = type;
        this.timestamp = timestamp;
        this.transactionAccountId = transactionAccountId;
    }

    public AccountNumber accountNumber() {return this.accountNumber;}

    public AmountTransaction amount(){
        return this.amountTransaction;
    }

    public AmountCost amountCost(){
        return this.amountCost;
    }

    public TypeOfTransaction type(){
        return this.type;
    }

    public Instant timestamp(){
        return this.timestamp;
    }

    public TransactionAccountId accountId(){
        return this.transactionAccountId;
    }

    public static class Builder {

        private AccountNumber accountNumber;
        private AmountTransaction amountTransaction;
        private AmountCost amountCost;
        private TypeOfTransaction type;
        private Instant timestamp;
        private TransactionAccountId transactionAccountId;

        public Builder accountNumber(AccountNumber accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder amount(AmountTransaction amountTransaction) {
            this.amountTransaction = amountTransaction;
            return this;
        }

        public Builder amountCost(AmountCost amountCost) {
            this.amountCost = amountCost;
            return this;
        }

        public Builder type(TypeOfTransaction type) {
            this.type = type;
            return this;
        }

        public Builder timestamp() {
            this.timestamp = Instant.now();
            return this;
        }

        public Builder accountId(TransactionAccountId transactionAccountId) {
            this.transactionAccountId = transactionAccountId;
            return this;
        }

        public Transaction build() {
            return new Transaction(accountNumber,amountTransaction, amountCost, type, timestamp, transactionAccountId);
        }
    }
}
