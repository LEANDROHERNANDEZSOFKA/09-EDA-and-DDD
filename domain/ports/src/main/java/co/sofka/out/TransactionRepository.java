package co.sofka.out;

import co.sofka.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepository {
    Mono<Transaction> createTransaction(Transaction transaction);
}
