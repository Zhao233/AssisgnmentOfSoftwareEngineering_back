package com.example.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class UserController {
    @RequestMapping("/getUserInfo")
    public Map<Object, Object> getUserInfo(){
        Map<Object, Object> res = new HashMap<>();



        return res;
    }
}
