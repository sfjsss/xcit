package com.projectshadow.xcit.repository;

import com.projectshadow.xcit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findAllByEmailNot(String email);
}
