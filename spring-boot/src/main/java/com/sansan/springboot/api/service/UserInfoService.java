package com.sansan.springboot.api.service;

import com.sansan.springboot.api.entity.UserInfo;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
public interface UserInfoService {

    /**
     * 查询用户信息
     * @return
     */
    List<UserInfo> queryUserInfo();
}
