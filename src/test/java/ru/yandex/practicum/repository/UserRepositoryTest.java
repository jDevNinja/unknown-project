package ru.yandex.practicum.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.yandex.practicum.model.UserModel;

@Slf4j
@DataJpaTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Rollback(value = false)
class UserRepositoryTest {

  private final UserRepository userRepository;

  @Test
  void saveUserTest_shouldReturnSavedModelWithId() {
    UserModel savedUser =
        userRepository.save(UserModel.builder().login("Mike").password("pass").build());

    Assertions.assertNotNull(savedUser.getId());
  }
}
