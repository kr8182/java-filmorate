package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    int id; //целочисленный идентификатор
    String email; //электронная почта пользователя
    String login; //логин пользователя
    String name; //имя пользователя
    LocalDate birthday; //День рождения
}
