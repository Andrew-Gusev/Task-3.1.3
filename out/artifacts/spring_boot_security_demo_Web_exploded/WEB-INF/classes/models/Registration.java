package ru.itmentor.spring.boot_security.demo.models;

import lombok.Data;
import ru.itmentor.spring.boot_security.demo.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class Registration {
    private String username;
    private String password;

    public User formUser(PasswordEncoder passwordEncoder){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return user;
    }
}
