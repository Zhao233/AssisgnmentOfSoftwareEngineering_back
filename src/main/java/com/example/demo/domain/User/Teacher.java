package com.example.demo.domain.User;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Component
@Table(name = "teacher")
@Data
public class Teacher {
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
     * 是否由管理员同意
     * */
    @Column
    private int isAuthorized;

    /**
     * 创建时间
     * */
    @Column(name = "create_time")
    private long createTime;

    /**
     * 修改时间
     * */
    @Column(name = "update_time")
    private long updateTime;
}
