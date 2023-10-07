package ru.javamentor.springmvc.util;

import org.springframework.stereotype.Component;
import ru.javamentor.springmvc.model.Role;
import ru.javamentor.springmvc.model.User;
import ru.javamentor.springmvc.repositories.RoleRepository;
import ru.javamentor.springmvc.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @PostConstruct
    public void initializedDataBase() {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleRepository.findById(1L).orElse(null));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleRepository.findById(2L).orElse(null));
        User user1 = new User("Steve","Jobs", 25,
                "user@mail.com", "user","user",roles1);
        User user2 = new User("Brian","O'connor", 30,
                "admin@yandex.ru", "admin","admin",roles2);
        userService.save(user1);
        userService.save(user2);
    }
}
