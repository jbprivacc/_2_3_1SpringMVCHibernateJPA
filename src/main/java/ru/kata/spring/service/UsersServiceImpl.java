package ru.kata.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.dao.UsersDao;
import ru.kata.spring.model.Users;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersSERVICE {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @NotNull
    @Transactional
    @Override
    public void add(Users user) {
        usersDao.add(user);
    }

    @NotNull
    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return usersDao.listUsers();
    }

    @NotNull
    @Transactional
    @Override
    public Users get(long id) {
        return usersDao.show(id);
    }


    @NotNull
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
