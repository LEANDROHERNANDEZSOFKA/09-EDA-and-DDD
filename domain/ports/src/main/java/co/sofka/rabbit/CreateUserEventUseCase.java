package co.sofka.rabbit;

import co.sofka.commands.CreateUserCommand;
import co.sofka.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateUserEventUseCase {
    Flux<DomainEvent> publish(Mono<CreateUserCommand> createUserCommandMono);
}
