package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Film.
 */
@Data
@Builder
public class Film {

    int id; //целочисленный идентификатор
    String name; //Наименование
    String description; //описание
    LocalDate releaseDate; //Релизная дата
    int duration; //Длительность

}
