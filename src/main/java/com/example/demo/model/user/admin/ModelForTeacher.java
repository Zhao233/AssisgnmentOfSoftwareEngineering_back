package com.example.demo.model.user.admin;

import lombok.Data;

@Data
public class ModelForTeacher {
    long id;
    String name;
    String phone;
    String email;
    long createTime;
    long updateTime;

    public ModelForTeacher(long id, String name, String phone, String email, long createTime, long updateTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
