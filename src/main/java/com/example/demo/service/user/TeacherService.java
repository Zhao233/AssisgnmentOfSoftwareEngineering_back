package com.example.demo.service.user;

import com.example.demo.model.user.admin.ModelForTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<ModelForTeacher> getAllTeacher(String search, Pageable pageable);
}
