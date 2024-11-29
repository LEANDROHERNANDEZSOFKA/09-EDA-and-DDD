package co.sofka;

import co.sofka.events.AccountCreatedEvent;
import co.sofka.events.CreateUserEvent;
import co.sofka.events.TransactionCreatedEvent;
import co.sofka.generic.EventChange;
import co.sofka.vo.account.*;
import co.sofka.vo.account.AccountUserId;
import co.sofka.vo.transaction.AmountCost;
import co.sofka.vo.transaction.AmountTransaction;
import co.sofka.vo.transaction.TimeStamp;
import co.sofka.vo.transaction.TransactionAccountId;
import co.sofka.vo.user.*;

public class UserChange  extends EventChange {
    public UserChange(User user) {

        apply((CreateUserEvent event) ->{
            user.firstname=new Firstname(event.getFirstname());
            user.lastName=new LastName(event.getLastname());
            user.email=new Email(event.getEmail());
            user.password=new Password(event.getPassword());
            user.role=event.getRole();
        });

        apply((AccountCreatedEvent event)->{
            user.account=new Account.Builder()
                    .userId(new AccountUserId(event.getId()))
                    .accountNumber(new AccountNumber(event.getNumber()))
                    .amount(new Amount(event.getAmount()))
                    .createdAt(new CreatedAt())
                    .setIsDeleted(new IsDeleted(false))
                    .build();
        });

        apply((TransactionCreatedEvent event)->{
            Transaction transaction=new Transaction.Builder()
                    .amount(new AmountTransaction(event.getAmount()))
                    .amountCost(new AmountCost(event.getAmountCost()))
                    .type(event.getTypeTrans())
                    .timestamp()
                    .accountId(new TransactionAccountId(event.getCustomerId()))
                    .build();
            user.transactionList.add(transaction);
        });
    }
}
