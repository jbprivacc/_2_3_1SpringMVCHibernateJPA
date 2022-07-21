package ru.kata.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.model.Users;
import ru.kata.spring.repository.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersSERVICE {

    private final UsersRepository usersRepository;


    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Transactional
    @Override
    public void add(Users user) {
       usersRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    @Override
    public Users get(long id) {
        return usersRepository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public void update(Users updatedUser) {
        usersRepository.saveAndFlush(updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        usersRepository.delete(id);
    }
}
