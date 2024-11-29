package co.sofka.rabbit;

import co.sofka.commands.CreateTransactionCommand;
import co.sofka.events.TransactionCreatedEvent;
import co.sofka.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateTransactionEventUseCase {
    Flux<DomainEvent> publish(Mono<CreateTransactionCommand> createTransactionCommand);
}
