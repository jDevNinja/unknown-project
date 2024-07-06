package ru.yandex.practicum.repository.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.User;

@Component
public class UserMapper implements RowMapper<User> {
  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    int id = rs.getInt("id");
    String login = rs.getString("login");
    String password = rs.getString("password");

    return User.builder().id(id).login(login).password(password).build();
  }
}
