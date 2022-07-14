package ru.kata.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.dao.UsersDao;
import ru.kata.spring.model.Users;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersSERVICE {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Transactional
    @Override
    public void add(Users user) {
        usersDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return usersDao.listUsers();
    }

    @Transactional
    @Override
    public Users get(long id) {
        return usersDao.show(id);
    }

    @Transactional(readOnly = true)
    @Override
    public void update(long id, Users updatedUser) {
        usersDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        usersDao.delete(id);
    }
}
