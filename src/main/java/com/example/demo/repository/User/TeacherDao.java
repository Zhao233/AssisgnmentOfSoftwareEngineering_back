package com.example.demo.repository.User;

import com.example.demo.domain.User.Teacher;
import com.example.demo.model.user.admin.ModelForTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Long> {
    /** For Admin */
    @Query(value = "SELECT new com.example.demo.model.user.admin.ModelForTeacher(" +
            "teacher.id, " +
            "teacher.name, " +
            "teacher.phone, " +
            "teacher.email, " +
            "teacher.createTime, " +
            "teacher.updateTime) FROM Teacher teacher WHERE teacher.name like ?1 AND teacher.isAuthorized = 1")
    Page<ModelForTeacher> getAllAuthorizedByNameLike(String search, Pageable pageable);

    /** For Admin */
    @Query(value = "SELECT new com.example.demo.model.user.admin.ModelForTeacher(" +
            "teacher.id, " +
            "teacher.name, " +
            "teacher.phone, " +
            "teacher.email, " +
            "teacher.createTime, " +
            "teacher.updateTime) FROM Teacher teacher WHERE teacher.name like ?1 AND teacher.isAuthorized = 0")
    Page<ModelForTeacher> getAllNotAuthorizedByNameLike(String search, Pageable pageable);


//    @Query(value = "SELECT teacher FROM Teacher teacher WHERE teacher.name like ?1")
//    Page<Teacher> getAllByNameLike(String search, Pageable pageable);

//    Page<Teacher> findAllByNameIsLike(String search, Pageable pageable);

    Teacher findTeacherByName(String name);
}
