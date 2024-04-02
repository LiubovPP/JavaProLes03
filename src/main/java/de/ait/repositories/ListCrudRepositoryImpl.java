package de.ait.repositories;

import de.ait.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListCrudRepositoryImpl implements UserCrudRepository {
    private final List<User> users = new ArrayList<>();
    private Long currentID = 1L;
    @Override
    public void save(User element) {
        if (element instanceof User) {
            User user = element;
            user.setId(currentID++);
            users.add(user);
            System.out.println("Пользователь успешно сохранен!");
        } else {
            System.err.println("Ошибка: переданный элемент не является пользователем");
        }
    }

    @Override
    public List findAll() {
        /*System.out.println("\nСписок пользователей:");
        for (model.User user : users) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail());
        }
        return null;*/
        return new ArrayList<>(users);// чтоб не возвращать оригинальный список, в целях безопасности
    }

    @Override
    public User findByID(Long id) {
        return users.stream().filter(user -> user.getId()==id.longValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(User element) {

    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public List<User> findUserByStartingName(String prefix) {
        return users.stream()
                .filter(user -> user.getName().startsWith(prefix))
                .toList();
    }
}

