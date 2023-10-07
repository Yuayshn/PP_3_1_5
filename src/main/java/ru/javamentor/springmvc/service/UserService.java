package ru.javamentor.springmvc.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.springmvc.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll ();
    User getById(long id);
    void save(User user);
    void deleteById(long id);
    User findByUsername(String username);
    void update(User user);
    User passwordCoder(User user);
    UserDetails loadUserByUsername(String username);
}
