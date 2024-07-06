package ru.yandex.practicum.mappers;

import lombok.experimental.UtilityClass;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.User;

@UtilityClass
public class UserMapper {

  public static UserDto modelToDto(User userModel) {
    return UserDto.builder().id(userModel.getId()).login(userModel.getLogin()).build();
  }
}
