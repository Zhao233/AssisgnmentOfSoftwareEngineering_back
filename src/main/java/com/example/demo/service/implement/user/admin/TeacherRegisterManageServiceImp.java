package com.example.demo.service.implement.user.admin;

import com.example.demo.model.user.admin.ModelForTeacher;
import com.example.demo.repository.User.TeacherDao;
import com.example.demo.service.user.admin.TeacherRegisterManageService;
import com.example.demo.util.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("teacherRegisterManageService")
public class TeacherRegisterManageServiceImp implements TeacherRegisterManageService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public Page<ModelForTeacher> getNotAuthorizedTeacherList(String search, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return teacherDao.getAllNotAuthorizedByNameLike("%"+search+"%", pageRequest);
    }

    @Override
    public void agreeTeacherRegister(List<Integer> ids) {
        for(Integer temp : ids){
            teacherDao.agreeTeacherRegister(temp, TimeHelper.getNowTime());
        }
    }

    @Override
    public void refuseTeacherRegister(List<Integer> ids) {
        for(Integer temp : ids){
            teacherDao.deleteById(Long.valueOf(temp));
        }
    }
}
