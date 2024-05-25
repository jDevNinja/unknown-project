package ru.yandex.practicum.adapters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class StringToInstantDeserializer extends JsonDeserializer<Instant> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // тут будет строка из json, например "23.08.2024"
        String dateAsStr = p.getText();

        // преобразуем ее в LocalDate "23.08.2024"
        LocalDate localDate = LocalDate.parse(dateAsStr, formatter);

        // преобразуем в Instant "2024-08-23T00:00:00Z"
        return localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
    }
}
