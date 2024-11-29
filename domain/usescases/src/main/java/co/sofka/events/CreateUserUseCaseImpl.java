package co.sofka.events;

import co.sofka.User;
import co.sofka.commands.CreateUserCommand;
import co.sofka.generic.DomainEvent;
import co.sofka.rabbit.Bus;
import co.sofka.rabbit.CreateUserEventUseCase;
import co.sofka.rabbit.EventRepository;
import co.sofka.vo.user.Email;
import co.sofka.vo.user.Firstname;
import co.sofka.vo.user.LastName;
import co.sofka.vo.user.Password;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateUserUseCaseImpl implements CreateUserEventUseCase {

    private final Bus bus;
    private final EventRepository eventRepository;

    public CreateUserUseCaseImpl(Bus bus, EventRepository eventRepository) {
        this.bus = bus;
        this.eventRepository = eventRepository;
    }


    @Override
    public Flux<DomainEvent> publish(Mono<CreateUserCommand> createUserCommandMono) {
        return createUserCommandMono.flatMapIterable(command -> {
            User user=new User(
                    new Firstname(command.getFirstname()),
                    new LastName(command.getLastname()),
                    new Email(command.getEmail()),
                    new Password(command.getPassword()),
                    command.getRole()
            );

            return user.getUncommittedChanges();
        }).map(event->{
            bus.publish(event);
            return event;
        }).flatMap(eventRepository::save);
    }
}
