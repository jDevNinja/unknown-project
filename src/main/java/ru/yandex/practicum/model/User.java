package ru.yandex.practicum.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import ru.yandex.practicum.adapters.InstantToStringSerializer;
import ru.yandex.practicum.adapters.StringToInstantDeserializer;

import java.time.Instant;

@Data
public class User {
    private String login;
    private String password;

    /**
     * Дата рождения вида "24-05-2024"
     */
    @JsonDeserialize(using = StringToInstantDeserializer.class)
    @JsonSerialize(using = InstantToStringSerializer.class)
    private Instant birthDate;
}



