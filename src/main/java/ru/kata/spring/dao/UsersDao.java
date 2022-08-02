package ru.kata.spring.dao;

import ru.kata.spring.model.Users;

import java.util.List;

public interface UsersDao {
    void add(Users user);

    List<Users> listUsers();

    Users show(long id);

    void update(long id);

    void delete(long id);
}
