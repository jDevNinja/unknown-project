package ru.yandex.practicum.handler;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yandex.practicum.exceptions.UserNotFoundException;

@RestControllerAdvice
@Slf4j
public class MainExceptionHandler {

  //  @ExceptionHandler(value = {UserNotFoundException.class}) можно указать типы исключений в
  // аннотации
  //      либо подходящий обработчик будет выбран по типу исключения в сигнатуре метода
  //  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler
  public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex) {
    // для более полного контроля над процессом формирования ответа можно использовать
    // ResponseEntity
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of("errorCode", "404", "errorMessage", "NOT_FOUND", "reason", ex.getMessage()));
  }

  // good practice - добавить общий обработчик для всех непредусмотренных исключений
  @ExceptionHandler
  public ResponseEntity<Map<String, String>> handleUserNotFoundException(Exception ex) {
    log.warn("Произошла ошибка: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .header("X-CUSTOM-HEADER", "JUST FOR FUN")
        .body(
            Map.of(
                "errorCode",
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                "errorMessage",
                (HttpStatus.INTERNAL_SERVER_ERROR.name()),
                "reason",
                ex.getMessage()));
  }
}
