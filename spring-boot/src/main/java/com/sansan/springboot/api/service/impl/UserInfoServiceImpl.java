package com.sansan.springboot.api.service.impl;

import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.mapper.UserInfoMapper;
import com.sansan.springboot.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryUserInfo() {
        return userInfoMapper.queryUserInfo();
    }

    @Override
    public UserInfo getUserInfo(String userName, String password) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        params.put("password", password);

        return userInfoMapper.getUserInfo(params);
    }


}
