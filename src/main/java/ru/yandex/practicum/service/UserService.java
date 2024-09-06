package ru.yandex.practicum.service;

import java.util.List;
import ru.yandex.practicum.dto.UserDto;

public interface UserService {
  List<UserDto> findAllUsers();

  UserDto createUser(UserDto user);

  UserDto findUserByLogin(String login);
}
