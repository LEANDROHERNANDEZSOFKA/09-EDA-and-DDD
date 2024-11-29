package co.sofka;

import co.sofka.generic.DomainEvent;
import co.sofka.rabbit.EventRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter implements EventRepository {

    private final ReactiveMongoTemplate template;

    public MongoRepositoryAdapter(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Flux<DomainEvent> findById(String aggregateId) {
        return null;
    }

    @Override
    public Mono<DomainEvent> save(DomainEvent domainEvent) {
        return null;
    }
}
