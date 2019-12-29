package com.example.demo.service.implement.user;

import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.repository.User.TeacherDao;
import com.example.demo.service.user.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Page<ModelForTeacher> getAllTeacher(String search, Pageable pageable) {
        return teacherDao.getAllAuthorizedByNameLike(search, pageable);
    }
}
