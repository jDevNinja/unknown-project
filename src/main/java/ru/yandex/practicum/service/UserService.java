package ru.yandex.practicum.service;

import ru.yandex.practicum.model.User;

import java.util.List;

public interface UserService {
  List<User> findAllUsers();

  User createUser(User user);
}
