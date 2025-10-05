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

    private int id; //целочисленный идентификатор
    @NotBlank(message = ExceptionMessages.EMPTY_NAME)
    private String name; //Наименование
    @Size(max = 200, message = ExceptionMessages.MAX_DESCRIPTION)
    private String description; //описание
    private LocalDate releaseDate; //Релизная дата
    @PositiveOrZero(message = ExceptionMessages.POSITIVE_DURATION)
    private int duration; //Длительность

}
