package com.example.demo.domain.Info;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "competition_relation")
@Data
public class CompetitionRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "upper")
    private long upperId;

    @Column(name = "lower")
    private long lowerId;
}
