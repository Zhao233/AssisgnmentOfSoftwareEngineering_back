package com.example.demo.controller.user;

import com.example.demo.domain.User.UserInfo;
import com.example.demo.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public Map<Object, Object> getUserInfo(HttpServletRequest request) throws JsonProcessingException {
        Map<Object, Object> res = new HashMap<>();
        String token = request.getHeader("Authorization");

        UserInfo userInfo = userService.getUserInfoByToken(token);

        if(userInfo != null){
            res.put("status", 200);
            res.put("data", userInfo);
        }

        return res;
    }
}
