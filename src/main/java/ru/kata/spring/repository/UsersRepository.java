package ru.kata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
