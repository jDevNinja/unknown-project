package ru.yandex.practicum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.mappers.UserMapper;
import ru.yandex.practicum.model.Group;
import ru.yandex.practicum.model.UserModel;
import ru.yandex.practicum.repository.UserRepository;
import ru.yandex.practicum.repository.UserSpecifications;

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
  public List<UserDto> findUsersByFilter(Group group, Integer age) {
    List<Specification<UserModel>> specifications = new ArrayList<>();

    if (Objects.nonNull(group)) {
      specifications.add(UserSpecifications.hasGroup(group));
    }

    if (Objects.nonNull(age)) {
      specifications.add(UserSpecifications.hasAgeGreater(age));
    }

    Specification<UserModel> allConditions =
        specifications.stream()
            .reduce(
                (userModelSpecification, userModelSpecification2) ->
                    userModelSpecification.and(userModelSpecification2))
            .get();

    List<UserModel> foundUsers = userRepository.findAll(allConditions);

    return foundUsers.stream().map(model -> userMapper.modelToDto(model)).toList();
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
