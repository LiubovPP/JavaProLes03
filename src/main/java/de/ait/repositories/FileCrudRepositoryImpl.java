package de.ait.repositories;

import de.ait.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileCrudRepositoryImpl implements UserCrudRepository{

    private String fileName;
    private Long currentID = 1L;
    private List<User> users = new ArrayList<>();


    @Override
    public void save(User element) {
        if (element instanceof User) {
            User user = (User) element;
            users.add(user);
            saveToFile(element);
            System.out.println("Пользователь успешно сохранен!");
        } else {
            System.err.println("Ошибка: переданный элемент не является пользователем");
        }
    }

    @Override
    public List<User> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(s -> s.split(";"))
                    .map(userArray -> new User(Long.parseLong(userArray[0]), userArray[1],userArray[2]))
                    .toList();
        }catch (IOException e){
            System.out.printf("File read error ");
            return Collections.EMPTY_LIST;
        }
    }

    private void saveToFile(User user1) {
        user1.setId(currentID++);
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            for (User user : users) {
                writer.write(user.getId()+";"+user.getName() + ";" + user.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    @Override
    public User findByID(Long id) {
        return findAll().stream().filter(user -> user.getId()==id.longValue())
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
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(s->s.split(";"))
                    .filter(user -> user[1].startsWith(prefix))
                    .map(uArr -> new User(Long.parseLong(uArr[0]), uArr[1], uArr[2]))
                    .toList();
        } catch (IOException e){
            System.out.println("File read error");
            return Collections.EMPTY_LIST;
        }
    }
}

