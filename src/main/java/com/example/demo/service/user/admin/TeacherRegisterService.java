package com.example.demo.service.user.admin;

import com.example.demo.domain.User.Teacher;
import com.example.demo.model.user.admin.ModelForTeacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeacherRegisterService {
    Page<ModelForTeacher> getNotAuthrizedTeacherList(String search, int offset, int pagesize);

    Teacher agreeTeacherRegister(long id, String name, String email, String phone);

    void refuseTeacherRegister(List<Integer> ids);
}
