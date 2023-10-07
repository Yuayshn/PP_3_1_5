package ru.javamentor.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.springmvc.model.Role;
import ru.javamentor.springmvc.model.User;
import ru.javamentor.springmvc.repositories.RoleRepository;
import ru.javamentor.springmvc.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(passwordCoder(user));
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @PostConstruct
    public void addDefaultUser() {
        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleRepository.findById(1L).orElse(null));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleRepository.findById(1L).orElse(null));
        roles2.add(roleRepository.findById(2L).orElse(null));
        User user1 = new User("Steve","Jobs", 25,
                "user@mail.com", "user","user",roles1);
        User user2 = new User("Brian","O'connor", 30,
                "admin@yandex.ru", "admin","admin",roles2);
        save(user1);
        save(user2);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}