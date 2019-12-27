package com.example.demo.service.implement.user;

import com.example.demo.domain.User.UserInfo;
import com.example.demo.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserInfo getUserInfoByToken(String token) throws JsonProcessingException {
        String userInfo_json = (String) redisTemplate.opsForValue().get("token");
        UserInfo userInfo = null;

        ObjectMapper objectMapper = new ObjectMapper();
        userInfo = objectMapper.readValue(userInfo_json, UserInfo.class);

        return userInfo;
    }
}
