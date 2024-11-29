package co.sofka.in.user;

import co.sofka.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {
    Mono<User> register(User user);
}
