package de.ait.service;

import de.ait.model.User;
import de.ait.repositories.UserCrudRepository;
import lombok.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Data
class UserServiceImplTest {
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(); // тут все сломалось ...

    @AfterEach
    void tearDown() {
        // Очистка данных после каждого теста (если необходимо)
    }

    @Test
    void addUser() {
        // Создание тестового пользователя
        User user = new User(1L, "John", "john@example.com");

        // Добавление пользователя
        userService.addUser(user);

        // Получение списка пользователей после добавления
        List<User> userList = userService.getAllUsers();

        // Проверка, что список не пустой
        assertFalse(userList.isEmpty());

        // Проверка, что добавленный пользователь присутствует в списке
        assertTrue(userList.contains(user));
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void userValidate() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findUserByStartingName() {
    }
}