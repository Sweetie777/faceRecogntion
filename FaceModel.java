package com.tang.model;

import lombok.Data;

/**
 * Author: Sweetie77
 * Created: 2019/8/28
 */

/**
 * 这样就不用写get set方法,也可以避免在开发过程中如果更改需求, 就不会因为忘记写get set而出现问题
 */

@Data
public class FaceModel {
    private Integer age; // 年龄
    private Integer beauty; // 颜值
    private String expression; // 表情
    private String faceShape; // 脸型
    private String gender; // 性别
    private String glasses; // 是否带有眼镜
    private String race; // 人种


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBeauty() {
        return beauty;
    }

    public void setBeauty(Integer beauty) {
        this.beauty = beauty;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFaceShape() {
        return faceShape;
    }

    public void setFaceShape(String faceShape) {
        this.faceShape = faceShape;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}