package ru.yandex.practicum.controller;

import ru.yandex.practicum.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserController {

    private final Map<String, User> loginToUser = new HashMap<>();

    public User createUser(User user) {
        loginToUser.put(user.getLogin(), user);
        return user;
    }
}
