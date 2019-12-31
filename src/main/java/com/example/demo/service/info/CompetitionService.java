package com.example.demo.service.info;

import com.example.demo.domain.Info.Competition;
import com.example.demo.domain.Info.CompetitionInfo;

import java.util.List;
import java.util.Map;

public interface CompetitionService {
    Map<String, Object> getAllCompetition(int page, int size, long teacherId);

    List<CompetitionInfo> getAllClassify();

    List<CompetitionInfo> getAllItemByClassifyId(long fatherId);



    Competition addCompetition(long classifyId, long itemId, long teacherId, String name);
}
