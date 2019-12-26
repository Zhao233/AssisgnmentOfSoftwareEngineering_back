package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userLoginService")
public class UserLoginService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        switch (name){
            case "admin" :
                return new User( "admin",
                        passwordEncoder.encode("123456"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));

            case "teacher" :
                return new User( "teacher",
                        passwordEncoder.encode("123456"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEACHER"));

            default:
                throw new UsernameNotFoundException("用户不存在！");
        }

    }
}
