package ru.yandex.practicum.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.adapters.MyConfig;
import ru.yandex.practicum.exceptions.UserAlreadyExistsException;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.repository.UserRepository;

@RequiredArgsConstructor
@Slf4j
@Component
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final MyConfig myConfig;

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAllUsers();
  }

  @Override
  public User createUser(User user) {
    Optional<User> userById = userRepository.findUserById(user.getLogin());

    if (userById.isPresent()) {
      String errorMessage =
          String.format("Пользователь с логином %s уже существует!", user.getLogin());
      log.warn(errorMessage);
      throw new UserAlreadyExistsException(errorMessage);
    }

    return userRepository.createUser(user);
  }

  @Override
  public User getUserByLogin(String login) {
    Optional<User> userById = userRepository.findUserById(login);
    return userById.orElseThrow(
        () -> {
          String message = String.format("Пользовтаель с логином %s не найден", login);
          log.warn(message);
          return new UserNotFoundException(message);
        });
  }
}
