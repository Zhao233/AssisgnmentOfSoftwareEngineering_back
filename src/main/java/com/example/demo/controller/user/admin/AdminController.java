package com.example.demo.controller.user.admin;

import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.service.user.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("getTeacherList")
    public Map<Object, Object> getTeacherList(@RequestBody Map<String,Object> map){
        Map<Object, Object> res = new HashMap<>();

        String search = (String) map.get("search");
        Integer page = (Integer) map.get("page");
        Integer size = (Integer) map.get("size");

        Page<ModelForTeacher> teacher_list = adminService.getTeacherList(search, page, size);

        res.put("status", 200);

        Map<Object, Object> data = new HashMap<>();
        data.put("total_size", teacher_list.getTotalElements());
        data.put("list", teacher_list.getContent());
        data.put("total_pages", teacher_list.getTotalPages());

        res.put("data", data);

        return res;
    }
}
