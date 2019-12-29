package com.example.demo.service.implement.user.admin;

import com.example.demo.domain.User.Teacher;
import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.repository.User.TeacherDao;
import com.example.demo.service.user.admin.AdminService;
import com.example.demo.util.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Page<ModelForTeacher> getTeacherList(String search, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return teacherDao.getAllAuthorizedByNameLike("%"+search+"%", pageRequest);
    }

    @Override
    public Teacher updateTeacher(long id, String name, String email, String phone) {
        Teacher teacher = teacherDao.getOne(id);
        teacher.setName(name);
        teacher.setEmail(email);
        teacher.setPhone(phone);
        teacher.setUpdateTime(TimeHelper.getNowTime());

        return teacherDao.save(teacher);
    }

    @Override
    public void deleteTeacher(List<Integer> ids) {
        for( Integer temp : ids){
            teacherDao.deleteById(Long.valueOf(temp));
        }
    }
}