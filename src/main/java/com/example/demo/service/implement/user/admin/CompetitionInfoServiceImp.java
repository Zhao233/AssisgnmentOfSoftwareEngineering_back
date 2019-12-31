package com.example.demo.service.implement.user.admin;

import com.example.demo.domain.Info.CompetitionInfo;
import com.example.demo.domain.Info.CompetitionRelation;
import com.example.demo.repository.info.CompetitionInfoDao;
import com.example.demo.repository.info.CompetitionRelationDao;
import com.example.demo.service.info.CompetitionInfoService;
import com.example.demo.util.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("competitionInfoService")
public class CompetitionInfoServiceImp implements CompetitionInfoService {
    @Autowired
    CompetitionInfoDao competitionInfoDao;

    @Autowired
    CompetitionRelationDao competitionRelationDao;

    @Override
    public List<CompetitionInfo> getAllClassify(){
        return competitionInfoDao.getAllByTypeEquals(CompetitionInfo.TYPE_CLASSIFY);
    }

    @Override
    public Page<CompetitionInfo> getAllCompetitionByType(String search, int type, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return competitionInfoDao.getAllByNameLikeAndTypeEquals("%"+search+"%",type,pageRequest);
    }

    @Override
    public Page<CompetitionInfo> getAllCompetitionItemByFatherId(String search, long fatherId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return competitionInfoDao.getAllCompetitionItemByFatherId("%"+search+"%", fatherId, pageRequest);
    }

    @Override
    public CompetitionInfo createCompetition(int type, String name, double score) {
        CompetitionInfo competitionInfo = new CompetitionInfo();
        competitionInfo.setCreateTime(TimeHelper.getNowTime());
        competitionInfo.setName(name);
        competitionInfo.setScore(score);
        competitionInfo.setType(type);


        return competitionInfoDao.save(competitionInfo);
    }

    @Override
    public CompetitionInfo createCompetition(int type, long fatherIdForItem, String name, double score) {
        CompetitionInfo competitionInfo = new CompetitionInfo();
        competitionInfo.setCreateTime(TimeHelper.getNowTime());
        competitionInfo.setUpdateTime(TimeHelper.getNowTime());
        competitionInfo.setName(name);
        competitionInfo.setScore(score);
        competitionInfo.setType(type);

        competitionInfo = competitionInfoDao.save(competitionInfo);

        CompetitionRelation competitionRelation = new CompetitionRelation();
        competitionRelation.setUpperId(fatherIdForItem);
        competitionRelation.setLowerId(competitionInfo.getId());

        competitionRelationDao.save(competitionRelation);

        return competitionInfo;
    }

    @Override
    public CompetitionInfo updateCompetition(long id, int type, String name, double score) {
        CompetitionInfo competitionInfo = competitionInfoDao.getOne(id);

        competitionInfo.setUpdateTime(TimeHelper.getNowTime());
        competitionInfo.setName(name);
        competitionInfo.setScore(score);
        competitionInfo.setType(type);

        return competitionInfoDao.save(competitionInfo);
    }

    @Override
    public void deleteCompetition(List<Integer> ids) {
        for( Integer temp : ids){
            competitionInfoDao.deleteById(Long.valueOf(temp));
        }
    }


}
