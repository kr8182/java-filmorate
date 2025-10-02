package ru.yandex.practicum.filmorate.service.film;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.messages.ValidationExceptionMessages;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class FilmService {
    private static final LocalDate BOUNDARY_DATE = LocalDate.of(1895, 12, 28);
    private final FilmStorage filmStorage;

    public FilmService(FilmStorage filmStorage) {
        this.filmStorage = filmStorage;
    }

    public List<Film> getAll() {
        return filmStorage.getAll();
    }

    public Film save(Film film) {
        validate(film);
        return filmStorage.save(film);
    }

    public Film validate(Film film) {
        if (film.getReleaseDate().isBefore(BOUNDARY_DATE)) {
            throw new ValidationException(ValidationExceptionMessages.RELEASE_DATE.toString());
        }
        return film;
    }
}