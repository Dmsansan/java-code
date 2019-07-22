package com.sansan.springboot.api.service.impl;

import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.mapper.UserInfoMapper;
import com.sansan.springboot.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;
//    @Override
//    public List<UserInfo> queryUserInfos() {
//        return userInfoMapper.queryUserInfos();
//    }


    @Override
    public List<UserInfo> queryUserInfo() {
        return userInfoMapper.queryUserInfo();
    }
}
