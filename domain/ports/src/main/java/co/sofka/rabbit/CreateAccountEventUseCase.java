package co.sofka.rabbit;

import co.sofka.commands.CreateAccountCommand;
import co.sofka.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateAccountEventUseCase {
    Flux<DomainEvent> publish(Mono<CreateAccountCommand> createAccountCommand);
}
