package ru.igoresha.app.services;

import ru.igoresha.app.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(Boolean sort, String by, Boolean desc);
    List<User> findByQuery(String query);
}
