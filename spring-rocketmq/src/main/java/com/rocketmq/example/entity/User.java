package com.rocketmq.example.entity;

import lombok.Data;

/**
 * @author siss
 * @date 2020/8/27  13:51
 */
@Data
public class User {
    private String name;
    private Integer age;
    private String sex;

    public User() {

    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
