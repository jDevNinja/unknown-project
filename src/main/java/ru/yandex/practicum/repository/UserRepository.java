package ru.yandex.practicum.repository;

import ru.yandex.practicum.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> findAllUsers();

  User createUser(User user);

  Optional<User> findUserById(String login);
}
