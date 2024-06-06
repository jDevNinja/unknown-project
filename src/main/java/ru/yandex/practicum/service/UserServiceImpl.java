package ru.yandex.practicum.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.repository.UserRepository;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAllUsers();
  }

  @Override
  public User createUser(User user) {
    return userRepository.createUser(user);
  }
}
