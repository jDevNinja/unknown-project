package ru.yandex.practicum.service;

import java.util.List;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.Language;

public interface UserService {
  List<UserDto> findAllUsers();

  UserDto createUser(UserDto user);

  List<UserDto> findUsersByFilter(Language language, Integer age, String login);

  UserDto findUserById(Integer id);
}
