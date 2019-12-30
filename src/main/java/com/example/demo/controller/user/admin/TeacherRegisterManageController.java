package com.example.demo.controller.user.admin;

import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.service.user.admin.TeacherRegisterManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/teacherRegister")
public class TeacherRegisterManageController {
    @Autowired
    TeacherRegisterManageService teacherRegisterManageService;

    @RequestMapping("getAllNotAuthorizedTeacherList")
    public Map getAllNotAuthorizedTeacherList(@RequestBody Map body){
        Map<Object, Object> res = new HashMap<>();

        String search = (String) body.get("search");
        Integer page = (Integer) body.get("page");
        Integer size = (Integer) body.get("size");

        Page<ModelForTeacher> teacher_list = teacherRegisterManageService.getNotAuthorizedTeacherList(search, page, size);

        res.put("status", 200);

        Map<Object, Object> data = new HashMap<>();
        data.put("total_size", teacher_list.getTotalElements());
        data.put("list", teacher_list.getContent());
        data.put("total_pages", teacher_list.getTotalPages());

        res.put("data", data);

        return res;
    }

    @RequestMapping("agreeTeacherRegister")
    public Map agreeTeacherRegister(@RequestBody Map body){
        Map<Object, Object> res = new HashMap<>();

        ArrayList<Integer> id_list = (ArrayList<Integer>) body.get("ids");

        teacherRegisterManageService.agreeTeacherRegister(id_list);

        res.put("status", 200);

        return res;
    }

    @RequestMapping("refuseTeacherRegister")
    public Map refuseTeacherRegister(@RequestBody Map body){
        Map<Object, Object> res = new HashMap<>();

        ArrayList<Integer> id_list = (ArrayList<Integer>) body.get("ids");

        teacherRegisterManageService.refuseTeacherRegister(id_list);

        res.put("status", 200);

        return res;
    }
}
