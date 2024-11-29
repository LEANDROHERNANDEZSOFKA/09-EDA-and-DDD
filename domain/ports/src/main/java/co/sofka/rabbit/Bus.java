package co.sofka.rabbit;

import co.sofka.generic.DomainEvent;

public interface Bus {
    void publish(DomainEvent domainEvent);
}
