package ru.yandex.practicum.service;

import java.util.List;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.User;

public interface UserService {
  List<UserDto> findAllUsers();

  User createUser(User user);

  User getUserByLogin(String login);
}
