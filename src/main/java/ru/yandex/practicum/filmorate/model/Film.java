package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.practicum.filmorate.messages.ExceptionMessages;

import java.time.LocalDate;

/**
 * Film.
 */
@Data
@Getter
@Setter
@Builder
public class Film {

    public int id; //целочисленный идентификатор
    @NotBlank(message = ExceptionMessages.EMPTY_NAME)
    String name; //Наименование
    @Size(max = 200, message = ExceptionMessages.MAX_DESCRIPTION)
    String description; //описание
    LocalDate releaseDate; //Релизная дата
    @PositiveOrZero(message = ExceptionMessages.POSITIVE_DURATION)
    int duration; //Длительность

}
