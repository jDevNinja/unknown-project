package ru.yandex.practicum.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.yandex.practicum.mappers.UserMapper;
import ru.yandex.practicum.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceAutoMockitoTest {

  @Mock private UserMapper userMapperMock;

  @Mock private UserRepository userRepositoryMock;

  @InjectMocks private UserServiceImpl userService;

  //  @Test
  //  void findUserByLogin_shouldThrowExceptionWhenNotFound() {
  //    String login = "absentLogin";
  //    Mockito.when(userRepositoryMock.findOneByLogin(login)).thenReturn(Optional.empty());
  //
  //    Assertions.assertThrows(UserNotFoundException.class, () ->
  // userService.findUsersByFilter(login));
  //
  //    Mockito.verify(userRepositoryMock).findOneByLogin(login);
  //    Mockito.verifyNoInteractions(userMapperMock);
  //  }
}
