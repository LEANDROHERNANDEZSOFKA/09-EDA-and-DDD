package co.sofka.rabbit;

public interface BusListener {
    void receiveAccountEvent(String json);
    void receiveTransactionEvent(String json);
    void receiveUserEvent(String json);
}
