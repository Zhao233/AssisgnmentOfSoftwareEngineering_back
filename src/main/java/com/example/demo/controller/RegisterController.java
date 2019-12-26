package com.example.demo.controller;

import com.example.demo.domain.User1;
import com.example.demo.service.UserService;
import com.example.demo.util.EncodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    /**
     * 活动管理
     * */
    @RequestMapping("/test")
    @ResponseBody
    public String toIndex(){
        return "Test";
    }

    @RequestMapping("/testPage")
    public String test(){
        return "Test";
    }

    @RequestMapping("/user/checkName")
    @ResponseBody
    public Boolean checkName(@Param("name") String name){
        return userService.checkIsUserNameExist(name);
    }

    @RequestMapping("/user/checkEmail")
    @ResponseBody
    public Boolean checkEmail(@Param("email") String email){
        return userService.checkIsEmailExist(email);
    }

    @RequestMapping("/user/checkPhone")
    @ResponseBody
    public Boolean checkPhone(@Param("phone") String phone){
        return userService.checkIsPhoneExist(phone);
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public Map<Object, Object> registerUser(@RequestBody Map<Object,String> body){

//            @RequestParam("name") String name,
//                                            @RequestParam("phone") String phone,
//                                            @RequestParam("email") String email,
//                                            @RequestParam("password") String password){
        Map<Object,Object> map = new HashMap<>();

        User1 user1 = new User1();
        user1.setName(body.get("name"));
        user1.setEmail(body.get("email"));
        user1.setPhone(body.get("phone"));
        user1.setPassword(body.get("password"));

        user1.setPassword( EncodeHelper.encode( user1.getPassword() ) );

        if(userService.registerUser(user1) != null) {
            map.put("result", "SUCCESS");
        } else {
            map.put("result", "FAILED");
        }

        return map;
    }
}
