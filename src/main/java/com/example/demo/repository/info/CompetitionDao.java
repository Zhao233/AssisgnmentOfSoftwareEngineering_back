package com.example.demo.repository.info;

import com.example.demo.domain.Info.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDao extends JpaRepository<Competition, Long> {
//    @Query(value = "SELECT new com.example.demo.model.info.ModelForCompetition( SELECT competitionInfo.name FROM CompetitionInfo competitionInfo WHERE competitionInfo.id = competition.upperId ) FROM Competition competition " +
//            "R JOIN CompetitionInfo competitionInfo " +
//            "ON competition.classifyId = ")

    @Query(value = "SELECT competition FROM Competition competition where competition.teacherId = ?1")
    Page<Competition> getAllCompetition(Long teacherId, Pageable pageable);
}
