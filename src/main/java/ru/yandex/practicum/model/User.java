package ru.yandex.practicum.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
  private Integer id;
  private String login;
  private String password;
}
