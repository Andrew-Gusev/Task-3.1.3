package ru.itmentor.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmentor.spring.boot_security.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
