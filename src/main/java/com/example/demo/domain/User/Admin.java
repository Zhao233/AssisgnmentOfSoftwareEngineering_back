package com.example.demo.domain.User;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Component
@Table(name = "admin")
@Data
public class Admin {
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
     * 登录密码
     * */
    @Column(name = "password")
    private String password;

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
