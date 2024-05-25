package ru.yandex.practicum;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;
import java.time.Duration;

@Data
class Film {
    private String title;
    private Duration length;
}

public class GsonMain {

    public static void main(String[] args) {
        String filmJson = "{\"title\":\"Star Wars\", \"length\": 124}";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Duration.class, new IntToDurationInMinutesAdapter());
        Gson gson = gsonBuilder.create();

        Film film = gson.fromJson(filmJson, Film.class);

        // toString и toJson - это не одно и тоже, вывод в консоль разный
        System.out.println("film.toString(): " + film.toString());
        System.out.println("gson.toJson(film): " + gson.toJson(film));
    }
}

class IntToDurationInMinutesAdapter extends TypeAdapter<Duration> {

    @Override
    public Duration read(JsonReader reader) throws IOException {
        long value = reader.nextLong();
        return Duration.ofMinutes(value);
    }

    @Override
    public void write(JsonWriter writer, Duration duration) throws IOException {
        writer.value(duration.toMinutes());
    }
}
