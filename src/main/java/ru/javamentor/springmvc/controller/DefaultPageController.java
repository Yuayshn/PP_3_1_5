package ru.javamentor.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.springmvc.model.User;

@Controller
public class DefaultPageController {

    @GetMapping("/admin")
    public String showAllUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "admin/admin_page";
    }

    @GetMapping("/user")
    public String showOneUser() {
        return "user/user_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
}
