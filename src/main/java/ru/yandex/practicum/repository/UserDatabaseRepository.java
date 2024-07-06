package ru.yandex.practicum.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.repository.mappers.UserMapper;

@Repository
@RequiredArgsConstructor
@Primary
public class UserDatabaseRepository implements UserRepository {
  private final JdbcTemplate jdbcTemplate;
  private final UserMapper userMapper;

  @Override
  public List<User> findAllUsers() {
    return jdbcTemplate.query("SELECT * FROM app_users;", userMapper);
  }

  @Override
  public User createUser(User user) {
    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(
        connection -> {
          PreparedStatement ps =
              connection.prepareStatement(
                  "INSERT INTO app_users (login, password) VALUES (?,?);",
                  Statement.RETURN_GENERATED_KEYS);
          ps.setObject(1, user.getLogin());
          ps.setObject(2, user.getPassword());
          return ps;
        },
        keyHolder);

    Integer generatedId = keyHolder.getKeyAs(Integer.class);
    user.setId(generatedId);
    return user;
  }

  @Override
  public Optional<User> findUserById(String login) {
    return Optional.empty();
  }
}
