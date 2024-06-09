package ru.yandex.practicum.adapters;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "unknown-project")
@Data
public class MyConfig {
  private String title;
  private Integer maxUsersCount;
}
