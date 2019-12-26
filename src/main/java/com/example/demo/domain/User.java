package com.example.demo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "user")
@Data
public class User {
    /**
     * 数据库id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 姓名
     * */
    @Column(name = "name")
    private String name;

    /**
     * 电话
     * */
    @Column(name = "phone")
    private String phone;

    /**
     * 姓名
     * */
    @Column(name = "email")
    private String email;

    /**
     * 密码
     * */
    @Column(name = "password")
    private String password;

}
