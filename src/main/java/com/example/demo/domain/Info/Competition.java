package com.example.demo.domain.Info;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "competition")
@Data
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "classify_id")
    private long classifyId;

    @Column(name = "item_id")
    private long itemId;

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
