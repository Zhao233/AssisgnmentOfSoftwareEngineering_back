package com.example.demo.service.user;

import com.example.demo.domain.User.UserInfo;
import com.example.demo.domain.User1;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
    boolean checkIsUserNameExist(String name);
    boolean checkIsEmailExist(String email);
    boolean checkIsPhoneExist(String phone);

    User1 registerUser(User1 newUser1);

    UserInfo getUserInfoFromDBByName(String name);

    UserInfo getUserInfoByToken(String token) throws JsonProcessingException;
}
