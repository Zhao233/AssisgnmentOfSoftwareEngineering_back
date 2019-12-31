package com.example.demo.controller.user.teacher;

import com.example.demo.model.info.ModelForCompetition;
import com.example.demo.service.info.CompetitionService;
import com.example.demo.service.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher/competitionManagement")
public class CompetitionManagerController {
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private UserService userService;

    @RequestMapping("getAllCompetition")
    public Map getAllCompetition(@RequestBody Map body) throws JsonProcessingException {
        Map<String, Object> res = new HashMap();

        String token = (String) body.get("token");

        long id = userService.getUserInfoByToken(token).getId();

        Integer page = (Integer) body.get("page");
        Integer size = (Integer) body.get("size");

        Map data = competitionService.getAllCompetition(page,size, id);

        List<ModelForCompetition> list= (List<ModelForCompetition>) data.get("list");

        Long totleSize = (Long)data.get("total_size");
        Long totlePages = (Long) data.get("total_pages");

        res.put("status",200);
        res.put("total_size", totleSize);
        res.put("total_pages", totlePages);
        res.put("list", list);

        return res;
    }

    @RequestMapping("getClassifyList")
    public Map getClassifyList(){
        Map<Object, Object> res = new HashMap<>();

        res.put("status", 200);

        res.put("list", competitionService.getAllClassify());

        return res;
    }

    @RequestMapping("getItemList")
    public Map getItemList(@RequestBody Map body){
        Map<Object, Object> res = new HashMap<>();

        Integer fatherIdForItem = (Integer) body.get("fatherIdForItem");

        res.put("status", 200);

        res.put("list", competitionService.getAllItemByClassifyId(fatherIdForItem));

        return res;
    }

    @RequestMapping("addCompetition")
    public Map addCompetition(@RequestBody Map body) throws JsonProcessingException {
        Map<Object, Object> res = new HashMap<>();

        long classifyId = (Integer)body.get("classifyId");
        long itemId = (Integer)body.get("itemId");
        String token = (String) body.get("token");

        long teacherId = userService.getUserInfoByToken(token).getId();
        String name = (String) body.get("name");

        if(competitionService.addCompetition(classifyId, itemId, teacherId, name) != null){
            res.put("status", 500);
        } else {
            res.put("status", 200);
        }

        return res;
    }
}
