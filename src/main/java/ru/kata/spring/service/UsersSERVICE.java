package ru.kata.spring.service;

import ru.kata.spring.model.Users;

import java.util.List;

public interface UsersSERVICE {
    void add(Users user);

    List<Users> listUsers();

    Users get(long id);

    void update(Users updatedUser);

    void delete(long id);
}
