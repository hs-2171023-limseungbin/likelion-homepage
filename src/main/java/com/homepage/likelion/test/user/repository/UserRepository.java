package com.homepage.likelion.test.user.repository;

import com.homepage.likelion.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //userId
    Optional<User> findByUserId(String userId);
}
