package com.example.demo.controller.user.admin;

import com.example.demo.domain.Info.CompetitionInfo;
import com.example.demo.service.info.CompetitionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/competitionInfoManagement")
public class CompetitionInfoManagement {
    @Autowired
    CompetitionInfoService competitionInfoService;

    @RequestMapping("getClassifyList")
    private Map getAllFatherId(){
        Map<Object, Object> res = new HashMap<>();

        res.put("status", 200);

        res.put("list", competitionInfoService.getAllClassify());

        return res;
    }

    @RequestMapping("getCompetitionInfoList")
    private Map getCompetitionInfoList(@RequestBody Map body){
        Map<Object, Object> res = new HashMap<>();

        String search = (String) body.get("search");
        Integer page = (Integer) body.get("page");
        Integer size = (Integer) body.get("size");
        Integer type = (Integer) body.get("type");

        Integer fatherIdForItem = (Integer) body.get("fatherIdForItem");

        Page<CompetitionInfo> competitionInfo_list = null;

        competitionInfo_list = type == CompetitionInfo.TYPE_CLASSIFY ?  competitionInfoService.getAllCompetitionByType(search, type, page, size) :competitionInfoService.getAllCompetitionItemByFatherId(search, fatherIdForItem,page,size);

        res.put("status", 200);

        Map<Object, Object> data = new HashMap<>();
        data.put("total_size", competitionInfo_list.getTotalElements());
        data.put("list", competitionInfo_list.getContent());
        data.put("total_pages", competitionInfo_list.getTotalPages());

        res.put("data", data);

        return res;
    }

    @RequestMapping("createCompetitionInfo")
    public Map<Object, Object> createTeacher(@RequestBody Map<String, Object> body) {
        Map<Object, Object> res = new HashMap<>();

        CompetitionInfo competitionInfo = null;

        int type = (Integer)body.get("type")  ;
        String name = (String) body.get("name");
        double score = Double.parseDouble((String) body.get("score")) ;
        Integer fatherIdForItem = (Integer) body.get("fatherIdForItem");

        if(type == CompetitionInfo.TYPE_CLASSIFY){
            competitionInfo = competitionInfoService.createCompetition(type,name,score);
        } else {
            competitionInfo = competitionInfoService.createCompetition(type, fatherIdForItem, name,score);
        }

        if( competitionInfo != null){
            res.put("status", 200);
        } else {
            res.put("status", 500);
        }

        return res;
    }

    @RequestMapping("updateCompetitionInfo")
    public Map<Object, Object> updateTeacher(@RequestBody Map<String, Object> body) {
        Map<Object, Object> res = new HashMap<>();


        long id = (Integer)body.get("id");
        int type = (Integer)body.get("type");
        String name = (String) body.get("name");
        double score = (double) body.get("phone");
        Integer fatherIdForItem = (Integer) body.get("fatherIdForItem");

        if( competitionInfoService.updateCompetition(id,type,name,score) != null){
            res.put("status", 200);
        } else {
            res.put("status", 500);
        }

        return res;
    }

    @RequestMapping("deleteCompetitionInfo")
    public Map<Object, Object> deleteTeachers(@RequestBody Map body) {
        Map<Object, Object> res = new HashMap<>();

        ArrayList<Integer> id_list = (ArrayList<Integer>) body.get("ids");

        competitionInfoService.deleteCompetition(id_list);

        res.put("status", 200);

        return res;
    }
}
