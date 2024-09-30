package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.Group;
import ru.yandex.practicum.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public UserDto createUser(@RequestBody UserDto user) {
    log.info("Получен запрос на сохранение пользователя: {}", user);
    return userService.createUser(user);
  }

  @GetMapping
  public List<UserDto> findUsersByFilter(
      @RequestParam(value = "appGroup", required = false) Group appGroup,
      @RequestParam(value = "age", required = false) Integer age) {
    log.info("Получен запрос на получение пользователя по логину: {}", appGroup);
    return userService.findUsersByFilter(appGroup, age);
  }

  @GetMapping("/{id}")
  public UserDto findUserById(@PathVariable Integer id) {
    log.info("Получен запрос на получение пользователя по id: {}", id);
    return userService.findUserById(id);
  }
}
