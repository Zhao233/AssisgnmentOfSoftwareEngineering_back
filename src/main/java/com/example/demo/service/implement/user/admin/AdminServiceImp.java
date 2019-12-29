package com.example.demo.service.implement.user.admin;

import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.repository.User.TeacherDao;
import com.example.demo.service.user.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Page<ModelForTeacher> getTeacherList(String search, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return teacherDao.getAllByNameLike("%"+search+"%", pageRequest);
    }
}
