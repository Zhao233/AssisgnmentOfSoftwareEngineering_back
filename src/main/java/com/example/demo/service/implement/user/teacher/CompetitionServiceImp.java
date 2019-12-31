package com.example.demo.service.implement.user.teacher;

import com.example.demo.domain.Info.Competition;
import com.example.demo.domain.Info.CompetitionInfo;
import com.example.demo.model.info.ModelForCompetition;
import com.example.demo.repository.info.CompetitionDao;
import com.example.demo.repository.info.CompetitionInfoDao;
import com.example.demo.service.info.CompetitionService;
import com.example.demo.util.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("competitionService")
public class CompetitionServiceImp implements CompetitionService {
    @Autowired
    private CompetitionDao competitionDao;

    @Autowired
    private CompetitionInfoDao competitionInfoDao;

    @Override
    public Map<String, Object> getAllCompetition(int page, int size, long teacherId){
        HashMap data = new HashMap();

        PageRequest pageRequest = PageRequest.of(page, size);

        List<ModelForCompetition> page1 = new LinkedList<>();

        Page<Competition> page2 = competitionDao.getAllCompetition(teacherId, pageRequest);

        for(Competition competition : page2.getContent()){
            String classifyName = competitionInfoDao.getNameById(competition.getClassifyId());
            String itemName = competitionInfoDao.getNameById(competition.getItemId());
            long createTime = competition.getCreateTime();
            long updateTime = competition.getUpdateTime();

            ModelForCompetition model = new ModelForCompetition(classifyName,itemName,createTime,updateTime);
            page1.add(model);
        }

        data.put("list", page1);
        data.put("total_size", page2.getTotalElements());
        data.put("total_pages", page2.getTotalPages());

        return data;
    }

    @Override
    public List<CompetitionInfo> getAllClassify(){
        return competitionInfoDao.findAllByTypeEquals(CompetitionInfo.TYPE_CLASSIFY);
    }

    @Override
    public List<CompetitionInfo> getAllItemByClassifyId(long fatherId){
        return competitionInfoDao.findAllItemByClassifyId(fatherId);
    }

    @Override
    public Competition addCompetition(long classifyId, long itemId, long teacherId, String name){
        Competition competition = new Competition();
        competition.setClassifyId(classifyId);
        competition.setItemId(itemId);
        competition.setName(name);
        competition.setTeacherId(teacherId);
        competition.setCreateTime(TimeHelper.getNowTime());
        competition.setUpdateTime(TimeHelper.getNowTime());

        competition = competitionDao.save(competition);

        return competition;
    }
}