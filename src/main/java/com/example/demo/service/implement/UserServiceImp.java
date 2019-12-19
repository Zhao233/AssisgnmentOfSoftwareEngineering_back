package com.example.demo.service.implement;

import com.example.demo.domain.User;
import com.example.demo.repository.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cookerService")
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

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
    public User registerUser(User newUser) {
        return userDao.save(newUser);
    }
}
