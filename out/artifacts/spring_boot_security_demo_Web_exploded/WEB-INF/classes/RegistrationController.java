package ru.itmentor.spring.boot_security.demo.controllers;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.models.Registration;
import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;

@Controller
@RequestMapping("/logining")
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/add")
    public String homePage(){
        return "add";
    }
    @PostMapping("/add")
    public String addUser(Registration registration){
        userRepository.save(registration.formUser(passwordEncoder));
        return "redirect:/login";
    }
}

