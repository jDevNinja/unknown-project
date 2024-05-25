package ru.yandex.practicum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<String, User> loginToUser = new HashMap<>();

    @PostMapping
    public User createUser(@RequestBody User user) {
        loginToUser.put(user.getLogin(), user);
        return user;
    }

    @GetMapping
    public List<User> findAllUsers() {
        Collection<User> allUsers = loginToUser.values();
        return new ArrayList<>(allUsers);
    }

}