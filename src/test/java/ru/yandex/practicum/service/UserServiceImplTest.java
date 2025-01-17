package ru.yandex.practicum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import ru.yandex.practicum.mappers.UserMapperImpl;
import ru.yandex.practicum.repository.UserRepository;

@SpringBootTest(classes = {UserServiceImpl.class, UserMapperImpl.class})
class UserServiceImplTest {

  @Autowired UserService userService;
  @Autowired ApplicationContext applicationContext;
  @MockBean UserRepository userRepository;

  //  @Test
  //  void findUserByLogin_shouldReturnUserDto() {
  //    String login = "user-login";
  //    Integer id = 555;
  //    String password = "pass";
  //
  //    when(userRepository.findOneByLogin(login))
  //        .thenReturn(
  //            Optional.of(UserModel.builder().id(id).login(login).password(password).build()));
  //
  //    UserDto expectedUser = UserDto.builder().id(id).login(login).password(password).build();
  //
  //    UserDto actualUser = userService.findUsersByFilter(login);
  //
  //    assertNotNull(actualUser);
  //    assertEquals(expectedUser, actualUser);
  //  }

  //  @Test
  //  void findUserByLogin_shouldThrowExceptionWhenNotFound() {
  //    String login = "user-login";
  //
  //    when(userRepository.findOneByLogin(login)).thenReturn(Optional.empty());
  //
  //    Assertions.assertThrows(UserNotFoundException.class, () ->
  // userService.findUsersByFilter(login));
  //  }
}
