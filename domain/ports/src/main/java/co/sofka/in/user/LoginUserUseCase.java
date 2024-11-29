package co.sofka.in.user;

import co.sofka.User;
import reactor.core.publisher.Mono;

public interface LoginUserUseCase {
    Mono<User> authenticate(User user);
}
