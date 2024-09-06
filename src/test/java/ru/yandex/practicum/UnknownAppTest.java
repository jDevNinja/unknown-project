package ru.yandex.practicum;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ru.yandex.practicum.dto.UserDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UnknownAppTest {

  private final ApplicationContext applicationContext;

  private final TestRestTemplate testRestTemplate;

  @Test
  void contextLoads() {
    System.out.println("Контекст инициализирован");
  }

  @Test
  void createUser_fullIntegrationTest() {
    String username = "testUser";
    String password = "testPass";
    UserDto userToSave = UserDto.builder().login(username).password(password).build();

    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    HttpEntity<UserDto> request = new HttpEntity<>(userToSave, headers);

    ResponseEntity<UserDto> response =
        testRestTemplate.exchange(
            "http://localhost:8080/users", HttpMethod.POST, request, UserDto.class);

    assertNotNull(response);
    assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    assertNotNull(response.getBody());
    UserDto actualUser = response.getBody();
    assertNotNull(actualUser.getId());

    assertThat(actualUser).usingRecursiveComparison().ignoringFields("id").isEqualTo(userToSave);
  }
}
