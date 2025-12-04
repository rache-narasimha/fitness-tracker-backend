package com.fitness.service;

import com.fitness.dto.RegisterRequest;
import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(RegisterRequest req) {
        // simple uniqueness check
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new IllegalArgumentException("username-taken");
        }
        String hashed = passwordEncoder.encode(req.getPassword());
        User user = new User(req.getUsername(), hashed);
        return userRepository.save(user);
    }
}
