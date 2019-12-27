package com.example.demo.service.implement.user;

import com.example.demo.domain.User.Admin;
import com.example.demo.domain.User.Teacher;
import com.example.demo.domain.User.UserInfo;
import com.example.demo.domain.User1;
import com.example.demo.repository.User.AdminDao;
import com.example.demo.repository.User.TeacherDao;
import com.example.demo.repository.UserDao;
import com.example.demo.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean checkIsUserNameExist(String name) {
        return userDao.checkIsUserNameExist(name) != 0;
    }

    @Override
    public boolean checkIsEmailExist(String email) {
        return userDao.checkIsEmailExist(email) != 0;
    }

    @Override
    public boolean checkIsPhoneExist(String phone) {
        return userDao.checkIsPhoneExist(phone) != 0;
    }

    @Override
    public User1 registerUser(User1 newUser1) {
        return userDao.save(newUser1);
    }

    @Override
    public UserInfo getUserInfoFromDBByName(String name){
        UserInfo userInfo = new UserInfo();

        Admin admin = null;
        admin = adminDao.findAdminByName(name);

        if(admin == null){
            Teacher teacher = null;
            teacher = teacherDao.findTeacherByName(name);

            userInfo = new UserInfo();
            userInfo.setName(teacher.getName());
            userInfo.setRole(teacher.getRole());

            return userInfo;
        }

        userInfo = new UserInfo();
        userInfo.setName(admin.getName());
        userInfo.setRole(admin.getRole());

        return userInfo;
    }

    @Override
    public UserInfo getUserInfoByToken(String token) throws JsonProcessingException {
        String userInfo_json = (String) redisTemplate.opsForValue().get(token);
        UserInfo userInfo = null;

        ObjectMapper objectMapper = new ObjectMapper();
        userInfo = objectMapper.readValue(userInfo_json, UserInfo.class);

        return userInfo;
    }
}
