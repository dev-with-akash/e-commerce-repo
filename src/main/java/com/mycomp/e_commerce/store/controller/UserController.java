package com.mycomp.e_commerce.store.controller;

import com.mycomp.e_commerce.store.model.User;
import com.mycomp.e_commerce.store.repository.UserRepository;
import com.mycomp.e_commerce.store.service.CostomUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("")
public class UserController {
    private final CostomUserDetailsService userService;
    private final UserRepository userRepository;

    public UserController(CostomUserDetailsService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, UserRepository userRepository1) {
        this.userService = userService;
        this.userRepository = userRepository1;
    }

    @PostMapping("/register")
    public User register (@RequestBody User user ){
        return  userRepository.save(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        var u = userRepository.findByUsername(user.getUsername());
        if(!Objects.isNull(u))
            return "success";
        return "failure";
    }

}
