package ru.yandex.practicum.filmorate.storage.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exceptions.NotFoundException;
import ru.yandex.practicum.filmorate.messages.LogMessages;
import ru.yandex.practicum.filmorate.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class InMemoryUserStorage implements UserStorage {

    private final Map<Integer, User> users = new HashMap<>();
    private int id = 1;

    /*Метод получения всех пользоваелей*/
    @Override
    public List<User> getAll() {
        log.info(String.valueOf(LogMessages.COUNT), users.size());
        return new ArrayList<>(users.values());
    }

    /*Метод сохранения пользователя*/
    @Override
    public User save(User user) {
        log.info(String.valueOf(LogMessages.TRY_ADD), user);
        user.setId(generateId());
        users.put(user.getId(), user);
        log.info(String.valueOf(LogMessages.ADD));
        return user;
    }

    /*Метод обновления пользователя*/
    @Override
    public User update(User user) {
        log.info(String.valueOf(LogMessages.TRY_UPDATE), user);
        if (!users.containsKey(user.getId())) {
            throw new NotFoundException(String.valueOf(LogMessages.MISSING));
        }
        return user;
    }

    /*Приватный метод генерации ID*/
    private int generateId() {
        return id++;
    }
}
