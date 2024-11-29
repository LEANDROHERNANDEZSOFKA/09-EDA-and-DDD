package co.sofka.data;

import co.sofka.generic.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Events")
public class Event {

    private String aggregateRootId;
    private String eventBody;
    private Date occurredOn;
    private String typeName;

    public Event() {
    }

    public Event(String aggregateRootId, String eventBody, Date occurredOn, String typeName) {
        this.aggregateRootId = aggregateRootId;
        this.eventBody = eventBody;
        this.occurredOn = occurredOn;
        this.typeName = typeName;
    }

    public static String wrapEvent(DomainEvent domainEvent, JsonMapper eventSerializer) throws JsonProcessingException {
        return eventSerializer.writeValueAsString(domainEvent);
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
