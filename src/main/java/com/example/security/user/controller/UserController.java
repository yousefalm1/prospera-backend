package com.example.security.user.controller;

import com.example.security.user.UserEntity;
import com.example.security.user.UserRepository;
import com.example.security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll(); // Fetches all users from database
        return ResponseEntity.ok(users); // Return the list of users
    }

    @PutMapping("/{id}/make-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> makeUserAdmin(@PathVariable Integer id) {
        userService.makeAdmin(id);
        return ResponseEntity.ok("User has been promoted to admin");
    }


}
