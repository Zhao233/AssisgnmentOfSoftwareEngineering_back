package com.example.demo.domain.Info;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "competition_info")
@Data
public class CompetitionInfo {
    public static final int TYPE_CLASSIFY = 0;
    public static final int TYPE_ITEM = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type")
    private int type;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private double score;

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
