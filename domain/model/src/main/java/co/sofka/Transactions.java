package co.sofka;

import co.sofka.generic.Entity;
import co.sofka.vo.transaction.*;

public class Transactions extends Entity<Transactionid> {

    private final Amount amount;
    private final AmountCost amountCost;
    private final TypeOfTransaction type;
    private final TimeStamp timestamp;
    private final AccountId accountId;

    public Transactions(Transactionid id, Amount amount, AmountCost amountCost, TypeOfTransaction type, TimeStamp timestamp, AccountId accountId) {
        super(id);
        this.amount = amount;
        this.amountCost = amountCost;
        this.type = type;
        this.timestamp = timestamp;
        this.accountId = accountId;
    }

    public Amount amount(){
        return this.amount;
    }

    public AmountCost amountCost(){
        return this.amountCost;
    }

    public TypeOfTransaction type(){
        return this.type;
    }

    public TimeStamp timestamp(){
        return this.timestamp;
    }

    public AccountId accountId(){
        return this.accountId;
    }
}
