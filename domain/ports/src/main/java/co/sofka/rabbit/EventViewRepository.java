package co.sofka.rabbit;

import co.sofka.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface EventViewRepository {
    Flux<DomainEvent> getAll(DomainEvent domainEvent);
}
