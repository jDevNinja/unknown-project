package ru.yandex.practicum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.mappers.UserMapperImpl;
import ru.yandex.practicum.model.UserModel;
import ru.yandex.practicum.repository.UserRepository;

@SpringBootTest(classes = {UserServiceImpl.class, UserMapperImpl.class})
class UserServiceImplTest {

  @Autowired UserService userService;
  @Autowired ApplicationContext applicationContext;
  @MockBean UserRepository userRepository;

  @Test
  void findUserByLogin_shouldReturnUserDto() {
    String login = "user-login";
    Integer id = 555;
    String password = "pass";

    when(userRepository.findOneByLogin(login))
        .thenReturn(
            Optional.of(UserModel.builder().id(id).login(login).password(password).build()));

    UserDto expectedUser = UserDto.builder().id(id).login(login).password(password).build();

    UserDto actualUser = userService.findUserByLogin(login);

    assertNotNull(actualUser);
    assertEquals(expectedUser, actualUser);
  }

  @Test
  void findUserByLogin_shouldThrowExceptionWhenNotFound() {
    String login = "user-login";

    when(userRepository.findOneByLogin(login)).thenReturn(Optional.empty());

    Assertions.assertThrows(UserNotFoundException.class, () -> userService.findUserByLogin(login));
  }
}
