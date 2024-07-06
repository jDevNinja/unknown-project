package ru.yandex.practicum.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public User createUser(@RequestBody User user) {
    log.info("Получен запрос на сохранение пользователя: {}", user);
    return userService.createUser(user);
  }

  @GetMapping
  public List<UserDto> findAllUsers() {
    log.info("Получен запрос на получение всех пользоватеей");
    return userService.findAllUsers();
  }

  @GetMapping("/{login}")
  public User getUserByLogin(@PathVariable String login) {
    log.info("Получен запрос на получение пользователя по id: {}", login);
    return userService.getUserByLogin(login);
  }
}
