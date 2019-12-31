package com.example.demo.model.info;

public class ModelForCompetition {
    String classifyName;
    String itemName;
    long createTime;
    long updateTime;

    public ModelForCompetition(String classifyName, String itemName, long createTime, long updateTime) {
        this.classifyName = classifyName;
        this.itemName = itemName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
