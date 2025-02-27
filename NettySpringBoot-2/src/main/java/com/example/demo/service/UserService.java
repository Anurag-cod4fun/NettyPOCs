package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
	// dummy database
    private final Map<String, User> userDB = new ConcurrentHashMap<>();

    public Flux<User> getAllUsers() {
        return Flux.fromIterable(userDB.values());
    }

    public Mono<User> getUserById(String id) {
        return Mono.justOrEmpty(userDB.get(id));
    }

    public Mono<User> createUser(User user) {
        userDB.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> updateUser(String id, User user) {
        user.setId(id);
        userDB.put(id, user);
        return Mono.just(user);
    }

    public Mono<Void> deleteUser(String id) {
        userDB.remove(id);
        return Mono.empty();
    }
}
