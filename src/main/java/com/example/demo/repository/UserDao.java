package com.example.demo.repository;

import com.example.demo.domain.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User1,Long> {
    @Query(value = "SELECT count(user.name) FROM User1 user where user.name = ?1")
    Integer checkIsUserNameExist(String name);

    @Query(value = "SELECT count(user.email) FROM User1 user where user.email = ?1")
    Integer checkIsEmailExist(String email);

    @Query(value = "SELECT count(user.phone) FROM User1 user where user.phone = ?1")
    Integer checkIsPhoneExist(String phone);
}
