package ru.yandex.practicum.service;

import java.util.List;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.AppUser;

public interface UserService {
  List<UserDto> findAllUsers();

  AppUser createUser(AppUser user);

  AppUser getUserByLogin(String login);
}
