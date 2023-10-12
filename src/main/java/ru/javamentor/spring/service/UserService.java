package ru.javamentor.spring.service;

import ru.javamentor.spring.model.User;
import javax.validation.Valid;
import java.util.List;

public interface UserService {
    void saveUser(User user);

    void updateUser(@Valid User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    User getUserById(long id);
}
