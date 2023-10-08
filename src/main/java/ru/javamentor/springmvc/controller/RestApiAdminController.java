package ru.javamentor.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springmvc.model.User;
import ru.javamentor.springmvc.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/adminApi")
public class RestApiAdminController {

    private final UserService userService;

    @Autowired
    public RestApiAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("user/{id}")
    public ResponseEntity<HttpStatus> editUser(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}