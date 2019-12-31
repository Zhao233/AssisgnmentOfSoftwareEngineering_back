package com.example.demo.service;

import com.example.demo.domain.User.Admin;
import com.example.demo.domain.User.Teacher;
import com.example.demo.repository.User.AdminDao;
import com.example.demo.repository.User.TeacherDao;
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

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private AdminDao adminDao;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin admin = adminDao.findAdminByName(name);
        Teacher teacher = null;

        if(admin != null){
            return new User(admin.getName(), passwordEncoder.encode(admin.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        } else {
            teacher = teacherDao.findTeacherByName(name);

            if(teacher == null){
                throw new UsernameNotFoundException("用户不存在！");
            }

            return new User(teacher.getName(), passwordEncoder.encode(teacher.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEACHER"));
        }

//        switch (name){
//            case "admin" :
//                return new User( "admin",
//                        passwordEncoder.encode("123456"),
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
//
//            case "teacher" :
//                return new User( "teacher",
//                        passwordEncoder.encode("123456"),
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEACHER"));
//
//            default:
//                throw new UsernameNotFoundException("用户不存在！");
//        }

    }
}
