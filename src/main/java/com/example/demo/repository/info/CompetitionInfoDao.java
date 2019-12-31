package com.example.demo.repository.info;

import com.example.demo.domain.Info.CompetitionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionInfoDao extends JpaRepository<CompetitionInfo, Long> {

    Page<CompetitionInfo> getAllByNameLikeAndTypeEquals(String search, int type, Pageable pageable);

    @Query(value = "SELECT competition FROM CompetitionInfo competition WHERE competition.name LIKE ?1 AND competition.id IN (" +
            "SELECT competitionRelation.lowerId FROM CompetitionRelation competitionRelation " +
            "WHERE competitionRelation.upperId = ?2) ")
    Page<CompetitionInfo> getAllCompetitionItemByFatherId(String search, long id, Pageable pageable);

    List<CompetitionInfo> getAllByTypeEquals(int type);

    /** For teacher */
    @Query(value = "select competitionInfo.name from CompetitionInfo competitionInfo where competitionInfo.id = ?1")
    String getNameById(long id);

    List<CompetitionInfo> findAllByTypeEquals(int type);

    @Query(value = "SELECT competitionInfo FROM CompetitionInfo competitionInfo WHERE " +
            "competitionInfo.id " +
            "IN " +
            "(SELECT competitionRelation.lowerId FROM CompetitionRelation competitionRelation WHERE competitionRelation.upperId = ?1)")
    List<CompetitionInfo> findAllItemByClassifyId(long id);
}
