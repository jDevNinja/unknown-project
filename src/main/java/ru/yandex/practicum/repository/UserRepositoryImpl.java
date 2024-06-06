package ru.yandex.practicum.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.User;

@Component
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

  public Optional<User> findUserById(String login) {
    return Optional.ofNullable(datasource.get(login));
  }
}
