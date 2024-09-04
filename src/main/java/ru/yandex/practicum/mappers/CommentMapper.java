package ru.yandex.practicum.mappers;

import org.mapstruct.Mapper;
import ru.yandex.practicum.pack.CommentDto;
import ru.yandex.practicum.pack.CommentEntity;

@Mapper(componentModel = "spring")
public interface CommentMapper {
  CommentDto commentEntityToDto(CommentEntity commentEntity);
}
