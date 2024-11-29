package co.sofka.events;

import co.sofka.Account;
import co.sofka.User;
import co.sofka.commands.CreateAccountCommand;
import co.sofka.generic.DomainEvent;
import co.sofka.rabbit.Bus;
import co.sofka.rabbit.CreateAccountEventUseCase;
import co.sofka.rabbit.EventRepository;
import co.sofka.vo.account.*;
import co.sofka.vo.user.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateAccountUseCaseImpl implements CreateAccountEventUseCase {

    private final Bus bus;
    private final EventRepository eventRepository;

    public CreateAccountUseCaseImpl(Bus bus, EventRepository eventRepository) {
        this.bus = bus;
        this.eventRepository = eventRepository;
    }

    @Override
    public Flux<DomainEvent> publish(Mono<CreateAccountCommand> createAccountCommand) {
        return createAccountCommand.flatMapMany(command ->
                eventRepository.findById(command.getCustomerId())
                        .collectList()
                        .flatMapIterable(events ->{

                            User user=User.from(UserId.of(command.getCustomerId()),events);

                            Account newAccount = new Account.Builder()
                                    .userId(new AccountUserId(command.getCustomerId()))
                                    .accountNumber(new AccountNumber(command.getNumber()))
                                    .amount(new Amount(command.getAmount()))
                                    .createdAt(new CreatedAt())
                                    .setIsDeleted(new IsDeleted(false))
                                    .build();

                            user.createAccount(newAccount);

                            return user.getUncommittedChanges();
                        }).map(event->{
                            bus.publish(event);
                            return event;
                        }).flatMap(eventRepository::save)
        );
    }



}
