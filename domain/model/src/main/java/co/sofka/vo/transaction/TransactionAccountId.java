package co.sofka.vo.transaction;

import co.sofka.generic.ValueObject;

public class TransactionAccountId implements ValueObject<String> {

    private final String accountId;

    public TransactionAccountId(String accountId) {
        if(accountId.isEmpty()){
            throw new IllegalArgumentException("Account ID cannot be empty");
        }
        this.accountId = accountId;
    }

    @Override
    public String value() {
        return this.accountId;
    }
}
