package com.example.demo.service.user.admin;

import com.example.demo.model.user.admin.ModelForTeacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeacherRegisterManageService {
    Page<ModelForTeacher> getNotAuthorizedTeacherList(String search, int offset, int pagesize);

    void agreeTeacherRegister(List<Integer> ids);

    void refuseTeacherRegister(List<Integer> ids);
}
