package ru.yandex.practicum.mappers;

import org.mapstruct.Mapper;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto modelToDto(UserModel appUser);

  UserModel dtoToModel(UserDto userDto);
}
