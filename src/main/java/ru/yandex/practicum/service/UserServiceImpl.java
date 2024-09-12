package ru.yandex.practicum.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.mappers.UserMapper;
import ru.yandex.practicum.model.UserModel;
import ru.yandex.practicum.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public List<UserDto> findAllUsers() {
    return userRepository.findAll().stream().map(userMapper::modelToDto).toList();
  }

  @Override
  public UserDto createUser(UserDto newUser) {
    UserModel userToSave = userMapper.dtoToModel(newUser);
    userToSave = userRepository.save(userToSave);
    return userMapper.modelToDto(userToSave);
  }

  @Override
  public UserDto findUserByLogin(String login) {
    Optional<UserModel> userById = userRepository.findOneByLogin(login);

    if (userById.isEmpty()) {
      String message = String.format("Пользовтаель с логином %s не найден", login);
      log.warn(message);
      throw new UserNotFoundException(message);
    }

    return userMapper.modelToDto(userById.get());
  }

  @Override
  public UserDto findUserById(Integer id) {
    Optional<UserModel> userById = userRepository.findById(id);

    if (userById.isEmpty()) {
      throw new UserNotFoundException(String.format("Пользователь с id %d не найден", id));
    }

    return userMapper.modelToDto(userById.get());
  }
}
