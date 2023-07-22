package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.entities.User;
import ru.itmentor.spring.boot_security.demo.services.UsersServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminsController {
    private final UsersServiceImpl usersService;

    @Autowired
    public AdminsController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public List<User> usersList() {
        List<User> userList = usersService.usersList();
        return userList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = usersService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        usersService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") long id, @RequestBody User user) {
        User existingUser = usersService.getUserById(id);
        if (existingUser != null) {
            user.setId(id);
            usersService.editUser(user, id);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> removeUser(@PathVariable("id") long id) {
        User existingUser = usersService.getUserById(id);
        if (existingUser != null) {
            usersService.removeUser(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
