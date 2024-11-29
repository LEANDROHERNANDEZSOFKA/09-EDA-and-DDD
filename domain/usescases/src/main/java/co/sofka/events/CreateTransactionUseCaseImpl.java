package co.sofka.events;

import co.sofka.Transaction;
import co.sofka.User;
import co.sofka.commands.CreateTransactionCommand;
import co.sofka.generic.DomainEvent;
import co.sofka.rabbit.Bus;
import co.sofka.rabbit.CreateTransactionEventUseCase;
import co.sofka.rabbit.EventRepository;
import co.sofka.vo.transaction.AmountTransaction;
import co.sofka.vo.transaction.TransactionAccountId;
import co.sofka.vo.user.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateTransactionUseCaseImpl implements CreateTransactionEventUseCase {

    private final Bus bus;
    private final EventRepository repository;

    public CreateTransactionUseCaseImpl(Bus bus, EventRepository repository) {
        this.bus = bus;
        this.repository = repository;
    }


    @Override
    public Flux<DomainEvent> publish(Mono<CreateTransactionCommand> createTransactionCommand) {
        return createTransactionCommand.flatMapMany(command->repository.findById(command.getAccountId())
                .collectList()
                .flatMapIterable(events->{
                    User user=User.from(UserId.of(command.getAccountId()),events);

                    Transaction transaction=new Transaction.Builder()
                            .amount(new AmountTransaction(command.getAmount()))
                            .type(command.getType())
                            .timestamp()
                            .accountId(new TransactionAccountId(command.getAccountId()))
                            .build();

                    user.addTransaction(transaction);

                    return user.getUncommittedChanges();
                }).map(event->{
                    bus.publish(event);
                    return event;
                }).flatMap(repository::save));
    }
}
