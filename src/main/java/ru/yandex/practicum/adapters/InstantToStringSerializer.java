package ru.yandex.practicum.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class InstantToStringSerializer extends JsonSerializer<Instant> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // преобразуем инстант в LocalDate 24.05.2024"
        LocalDate localDate = value.atZone(ZoneOffset.UTC).toLocalDate();

        // форматируем нужным образом и получаем строку "24-05-2024"
        String instantAsStr = localDate.format(formatter);

        // записываем строку в Json
        gen.writeString(instantAsStr);
    }
}
