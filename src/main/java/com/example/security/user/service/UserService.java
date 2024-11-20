package com.example.security.user.service;

import com.example.security.user.Role;
import com.example.security.user.UserEntity;
import com.example.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserEntity makeAdmin(Integer id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        user.setRole(Role.ADMIN);

        return userRepository.save(user);

    }

}
