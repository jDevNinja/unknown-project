package ru.yandex.practicum.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.service.UserService;

@Slf4j
@WebMvcTest(UserController.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserControllerTest {

  @MockBean UserService userService;
  private final ApplicationContext applicationContext;
  private final ObjectMapper mapper;
  private final MockMvc mockMvc;

  @Test
  @SneakyThrows
  void createUserTest() {
    String login = "login";
    String password = "password";
    Integer id = 123;
    UserDto userToSave = UserDto.builder().login(login).password(password).build();
    UserDto savedUser = UserDto.builder().id(id).login(login).password(password).build();

    when(userService.createUser(userToSave)).thenReturn(savedUser);

    mockMvc
        .perform(
            post("/users")
                .content(mapper.writeValueAsString(userToSave))
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(savedUser.getId()), Integer.class))
        .andExpect(jsonPath("$.login", is(login), String.class))
        .andExpect(jsonPath("$.password", is(password), String.class));

    MvcResult mvcResult =
        mockMvc
            .perform(
                post("/users")
                    .content(mapper.writeValueAsString(userToSave))
                    .characterEncoding(StandardCharsets.UTF_8)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

    String responseBody = mvcResult.getResponse().getContentAsString();
    log.info("Тело ответа: {}", responseBody);
  }
}
