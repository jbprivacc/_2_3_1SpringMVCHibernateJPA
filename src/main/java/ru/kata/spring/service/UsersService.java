package ru.kata.spring.service;

import ru.kata.spring.model.Users;

import java.util.List;

public interface UsersService {
    void add(Users user);

    List<Users> listUsers();

    Users get(long id);

    void update(long id);

    void delete(long id);
}
