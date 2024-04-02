package de.ait.service;

import de.ait.model.User;
import de.ait.model.repositories.UserCrudRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserCrudRepository repository;

//    public UserServiceImpl(UserCrudRepository repository) {
//        this.repository = repository;
//    }
    // внедрение зависимостей - Dependency Injection через конструктор или сеттер
    // или inversion of controller через Spring

    @Override
    public void addUser(User user) {
        if (userValidate(user)) {
            repository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean userValidate(User user) {
        return !user.getName().isEmpty() || !user.getEmail().contains("@");
    }

    @Override
    public User findUserByEmail(String email) {
        return getAllUsers().stream().filter(user -> user.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> findUserByStartingName(String prefix) {
        return repository.findUserByStartingName(prefix);
    }

}
