package ru.yandex.practicum.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
  private Integer id;
  private String login;
}
