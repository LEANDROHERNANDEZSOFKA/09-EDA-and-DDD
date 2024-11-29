package co.sofka.out;

import co.sofka.Transaction;
import reactor.core.publisher.Flux;

public interface TransactionViewsRepository {
    Flux<Transaction> getAllTransactions(Transaction transaction);
}
