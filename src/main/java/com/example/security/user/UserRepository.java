package com.example.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);


//    List<User> findByRole(Role role);


}
