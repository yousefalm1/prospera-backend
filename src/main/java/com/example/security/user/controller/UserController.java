package com.example.security.user.controller;

import com.example.security.user.UserEntity;
import com.example.security.user.UserRepository;
import com.example.security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user); // Create user using UserService
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        List<UserEntity> users = userService.getAllUsers(); // Fetch all users using UserService
//        return ResponseEntity.ok(users);
//    }

//    @GetMapping("/getUserById")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
//        return userService.getUserById(id)
//                .map(ResponseEntity::ok)
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

//    @PutMapping("/updateUser")
//    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
//        try {
//            UserEntity updatedUser = userService.updateUser(id, userDetails); // Update user using UserService
//            return ResponseEntity.ok(updatedUser);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return NOT_FOUND if user does not exist
//        }
//    @PutMapping("/{id}/make-admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<String> makeUserAdmin(@PathVariable Long id) {
//        userService.makeAdmin(id);
//        return ResponseEntity.ok("User has been promoted to admin");
//    }

//    @DeleteMapping("/deleteUser")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        try {
//            userService.deleteUser(id); // Delete user using UserService
//            return ResponseEntity.noContent().build(); // Return 204 No Content after deletion
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return NOT_FOUND if user does not exist
//        }
//    }


//    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        List<UserEntity> users = userRepository.findAll(); // Fetches all users from database
//        return ResponseEntity.ok(users); // Return the list of users
//    }
//
//    @PutMapping("/{id}/make-admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<String> makeUserAdmin(@PathVariable Integer id) {
//        userService.makeAdmin(id);
//        return ResponseEntity.ok("User has been promoted to admin");
//    }


}
