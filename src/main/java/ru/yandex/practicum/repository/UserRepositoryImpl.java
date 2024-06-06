package ru.yandex.practicum.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.yandex.practicum.model.User;

public class UserRepositoryImpl implements UserRepository {
  private final Map<String, User> datasource = new HashMap<>();

  public User createUser(User user) {
    datasource.put(user.getLogin(), user);
    return user;
  }

  public List<User> findAllUsers() {
    Collection<User> allUsers = datasource.values();
    return new ArrayList<>(allUsers);
  }
}
