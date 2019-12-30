package com.example.demo.service.info;

import com.example.demo.domain.Info.CompetitionInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompetitionInfoService {

    List<CompetitionInfo> getAllClassify();

    Page<CompetitionInfo> getAllCompetitionByType(String search, int type, int page, int size);

    Page<CompetitionInfo> getAllCompetitionItemByFatherId(String search, long fatherId, int page, int size);

    CompetitionInfo createCompetition(int type, String name, double score);

    CompetitionInfo createCompetition(int type, long fatherIdForItem, String name, double score);

    CompetitionInfo updateCompetition(long id, int type, String name, double score);

    void deleteCompetition(List<Integer> ids);
}
