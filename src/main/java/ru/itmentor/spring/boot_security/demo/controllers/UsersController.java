package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.entities.User;
import ru.itmentor.spring.boot_security.demo.services.UsersServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping(path="/api/user")
public class UsersController {
    private final UsersServiceImpl usersService;

    @Autowired
    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<User> getUserInfo(Principal principal) {
        User user = usersService.getUserByName(principal.getName());
        return ResponseEntity.ok(user);
    }
}
