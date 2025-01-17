//package ru.yandex.practicum.repository;
//
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import ru.yandex.practicum.model.UserModel;
//
//@DataJpaTest
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
//class UserRepositoryTest {
//
//  private final UserRepository userRepository;
//
//  @Test
//  void saveUserTest_shouldReturnSavedModelWithId() {
//    UserModel savedUser =
//        userRepository.save(UserModel.builder().login("Mike").password("pass").build());
//
//    Assertions.assertNotNull(savedUser.getId());
//  }
//}
