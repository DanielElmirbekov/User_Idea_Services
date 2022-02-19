package com.example.kgitschool.dao;

import com.example.kgitschool.Models.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByPhone(String phone);
    User findByPhone(String phone);
}
