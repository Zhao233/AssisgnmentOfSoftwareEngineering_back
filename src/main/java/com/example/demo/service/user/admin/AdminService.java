package com.example.demo.service.user.admin;

import com.example.demo.domain.User.Teacher;
import com.example.demo.model.user.admin.ModelForTeacher;
import org.springframework.data.domain.Page;

public interface AdminService {
    Page<ModelForTeacher> getTeacherList(String search, int offset, int pagesize);

    Teacher updateTeacher(long id, String name, String email, String phone);
}
