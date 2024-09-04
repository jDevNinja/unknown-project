package ru.yandex.practicum.service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exceptions.UserAlreadyExistsException;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.mappers.UserMapper;
import ru.yandex.practicum.model.AppUser;
import ru.yandex.practicum.pack.PostEntity;
import ru.yandex.practicum.repository.mappers.UserRepository;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  @Override
  public List<UserDto> findAllUsers() {
    List<AppUser> allUsers = userRepository.findAll();

    return allUsers.stream().map(model -> UserMapper.modelToDto(model)).toList();
  }

  @Override
  public AppUser createUser(AppUser user) {
    Optional<AppUser> userById = userRepository.findById(user.getId());

    List<PostEntity> postEntity = List.of(new PostEntity());

    log.info("Найдены следующие посты: {}", postEntity);

    if (userById.isPresent()) {
      String errorMessage =
          String.format("Пользователь с логином %s уже существует!", user.getLogin());
      log.warn(errorMessage);
      throw new UserAlreadyExistsException(errorMessage);
    }

    return userRepository.save(user);
  }

  @Override
  public AppUser getUserByLogin(String login) {
    Optional<AppUser> userById = userRepository.findByLogin(login);
    return userById.orElseThrow(
        () -> {
          String message = String.format("Пользовтаель с логином %s не найден", login);
          log.warn(message);
          return new UserNotFoundException(message);
        });
  }
}
