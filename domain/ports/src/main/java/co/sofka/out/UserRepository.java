package co.sofka.out;

import co.sofka.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User>create(User user);
    Mono<User>login(User user);
}
