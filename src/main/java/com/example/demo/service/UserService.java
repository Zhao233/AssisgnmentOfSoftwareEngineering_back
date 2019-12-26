package com.example.demo.service;

import com.example.demo.domain.User1;

public interface UserService {
    boolean checkIsUserNameExist(String name);
    boolean checkIsEmailExist(String email);
    boolean checkIsPhoneExist(String phone);

    User1 registerUser(User1 newUser1);
}
