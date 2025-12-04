package com.fitness.controller;

import com.fitness.dto.RegisterRequest;
import com.fitness.model.User;
import com.fitness.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        try {
            User created = userService.register(req);
            // do not return passwordHash
            return ResponseEntity.ok().body(
                String.format("user-created id=%d username=%s", created.getId(), created.getUsername())
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("error");
        }
    }
}

