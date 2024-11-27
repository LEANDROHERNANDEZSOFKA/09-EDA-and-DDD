package co.sofka.vo.transaction;

import co.sofka.generic.ValueObject;

import java.time.OffsetDateTime;

public class TimeStamp implements ValueObject<OffsetDateTime> {

    private final OffsetDateTime timestamp;

    public TimeStamp() {
        this.timestamp = OffsetDateTime.now();
    }

    @Override
    public OffsetDateTime value() {
        return this.timestamp;
    }
}
