package ru.yandex.practicum.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.yandex.practicum.exceptions.UserNotFoundException;
import ru.yandex.practicum.mappers.UserMapper;
import ru.yandex.practicum.repository.UserRepository;

import java.util.Optional;

class UserServiceHandMockitoTest {

  @Test
  void findUserByLogin_shouldThrowExceptionWhenNotFound() {
    String login = "absentLogin";

    UserRepository userRepoMock = Mockito.mock(UserRepository.class);
    UserMapper userMapperMock = Mockito.mock(UserMapper.class);
    Mockito.when(userRepoMock.findOneByLogin(login)).thenReturn(Optional.empty());

    UserServiceImpl service = new UserServiceImpl(userRepoMock, userMapperMock);

    Assertions.assertThrows(UserNotFoundException.class, () -> service.findUserByLogin(login));
    Mockito.verify(userRepoMock).findOneByLogin(login);
  }
}
