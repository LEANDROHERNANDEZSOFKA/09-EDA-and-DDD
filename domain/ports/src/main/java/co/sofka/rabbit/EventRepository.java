package co.sofka.rabbit;

import co.sofka.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventRepository {
    Flux<DomainEvent> findById(String aggregateId);
    Mono<DomainEvent> save(DomainEvent domainEvent);
}
