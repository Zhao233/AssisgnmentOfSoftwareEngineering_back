package com.example.demo.repository.info;

import com.example.demo.domain.Info.CompetitionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompetitionRelationDao extends JpaRepository<CompetitionRelation, Long> {
}
