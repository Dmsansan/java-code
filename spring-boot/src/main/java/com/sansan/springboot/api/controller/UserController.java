package com.sansan.springboot.api.controller;

import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.POST, produces = "application/json;utf-8")
    public List<UserInfo> queryUserInfo(){
        List<UserInfo> res = userInfoService.queryUserInfo();


        return res;
    }
}
