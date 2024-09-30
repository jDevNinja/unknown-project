package ru.yandex.practicum.dto;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.model.Group;

@Data
@Builder
public class UserDto {
  private Integer id;
  private String login;
  private String password;
  private Integer age;
  private Group appGroup;
}
