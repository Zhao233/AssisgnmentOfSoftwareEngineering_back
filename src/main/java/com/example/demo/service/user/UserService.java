package com.example.demo.service.user;

import com.example.demo.domain.User.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
    UserInfo getUserInfoByToken(String token) throws JsonProcessingException;
}
