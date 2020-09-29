package com.itstyle.quartz.service;

import com.itstyle.quartz.entity.UserEntity;

import java.util.List;

/**
 * @author siss
 * @date 2020/9/28  10:30
 */
public interface IUserService {

    void save(UserEntity userEntity);

    int queryCount(UserEntity userEntity);

    List<UserEntity> queryListByObject(UserEntity userEntity);

    int queryAllCount();
}
