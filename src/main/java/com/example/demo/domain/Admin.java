package com.example.demo.domain;

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
     * 姓名
     * */
    @Column(name = "password")
    private String password;

    /**
     * 姓名
     * */
    @Column(name = "create_time")
    private long createTime;

    /**
     * 姓名
     * */
    @Column(name = "update_time")
    private String updateTime;



}
