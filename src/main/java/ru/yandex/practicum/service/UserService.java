package ru.yandex.practicum.service;

import java.util.List;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.Group;

public interface UserService {
  List<UserDto> findAllUsers();

  UserDto createUser(UserDto user);

  List<UserDto> findUsersByFilter(Group group, Integer age);

  UserDto findUserById(Integer id);
}
