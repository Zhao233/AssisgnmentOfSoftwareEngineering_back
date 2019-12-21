package com.example.demo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "not_verified_teacher")
@Data
public class NotVerifiedTeacher {
    /**
     * 数据库id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 登录姓名
     * */
    @Column(name = "name")
    private String name;

    /**
     * 密码
     * */
    @Column(name = "password")
    private String password;

    /**
    *
    * */
    @Column(name = "is_verified")
    private int isVerified = 0;

    /**
     * 创建时间
     * */
    @Column(name = "create_time")
    private long createTime;

    /**
     * 修改时间
     * */
    @Column(name = "update_time")
    private String updateTime;
}
