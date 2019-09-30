package com.sansan.springboot.api.service;

import com.sansan.springboot.api.entity.UserInfo;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

public interface UserInfoService {

    /**
     * 查询用户信息
     *
     * @return
     */
    List<UserInfo> queryUserInfo();

    /**
     * 获取登录用户信息
     * @param userName
     * @param password
     * @return
     */
    UserInfo getUserInfo(String userName, String password);
}
