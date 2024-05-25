package ru.yandex.practicum;

import com.google.gson.Gson;
import lombok.Data;

import java.time.Duration;

@Data
class Film {
    private String title;
    private Duration length;
}

public class GsonMain {

    public static void main(String[] args) {
        String filmJson = "{\"title\":\"Star Wars\", \"length\": 124}";

        Gson gson = new Gson();

        gson.fromJson(filmJson, Film.class);
    }
}
