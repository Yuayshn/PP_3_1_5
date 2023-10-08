package ru.javamentor.springmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.springmvc.model.User;

@RestController
@RequestMapping("/userApi")
public class RestApiUserController {

    @GetMapping("/")
    public ResponseEntity<User> getAuthUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}
