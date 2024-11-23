package com.example.security.user.service;

import com.example.security.properties.PropertyRepository;
import com.example.security.transactions.TransactionEntity;
import com.example.security.user.Role;
import com.example.security.user.UserEntity;
import com.example.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
//    public UserEntity makeAdmin(Long id) {

//    public List<UserEntity> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<UserEntity> getUserById(Long id) {
//        return userRepository.findById(id);
//    }

//    public UserEntity makeAdmin(Long id) {
//
//        UserEntity user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
//
//        user.setRole(Role.ADMIN);
//
//        return userRepository.save(user);
//    }

//    public UserEntity updateUser(Long id, UserEntity userDetails) {
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setFirstName(userDetails.getFirstName());
//                    user.setLastName(userDetails.getLastName());
//                    user.setEmail(userDetails.getEmail());
//                    user.setPassword(userDetails.getPassword());
//                    user.setRole(userDetails.getRole());
//                    return userRepository.save(user);
//                })
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//    }
//
//
//    public void deleteUser(Long id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("User not found with id " + id);
//        }
//    }
//

//    public UserEntity createUserWithTransaction(UserEntity user, TransactionEntity transaction, Long propertyId) {
//        transaction.setUser(user);
//
//        if (propertyId != null) {
//            PropertyEntity property = propertyRepository.findById(propertyId)
//                    .orElseThrow(() -> new IllegalArgumentException("Property not found"));
//            transaction.setProperty(property);
//        }
//
//        // Add transaction to user's list
//        user.getTransactions().add(transaction);
//
//        return userRepository.save(user);
//    }



}

