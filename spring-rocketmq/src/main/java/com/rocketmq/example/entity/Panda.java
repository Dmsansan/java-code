package com.rocketmq.example.entity;

import lombok.Data;

/**
 * @author siss
 * @date 2020/8/27  13:53
 */
@Data
public class Panda {
    private String name;
    private Integer age;

    public Panda(){

    }

    public Panda(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
