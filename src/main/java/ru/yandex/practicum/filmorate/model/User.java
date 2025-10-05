package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.practicum.filmorate.messages.ExceptionMessages;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class User {
    private int id; //целочисленный идентификатор
    @Email(message = ExceptionMessages.INCORRECT_EMAIL)
    private String email; //электронная почта пользователя
    @NotBlank(message = ExceptionMessages.EMPTY_LOGIN)
    @Pattern(regexp = ".*\\S.", message = ExceptionMessages.LOGIN_WITHOUT_SPACE)
    private String login; //логин пользователя
    private String name; //имя пользователя
    @PastOrPresent(message = ExceptionMessages.INCORRECT_BIRTHDAY)
    private LocalDate birthday; //День рождения
}
