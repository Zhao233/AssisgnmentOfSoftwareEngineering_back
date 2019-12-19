package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    boolean checkIsUserNameExist(String name);
    boolean checkIsEmailExist(String email);
    boolean checkIsPhoneExist(String phone);

    User registerUser(User newUser);
}
