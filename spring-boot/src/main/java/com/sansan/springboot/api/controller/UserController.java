package com.sansan.springboot.api.controller;

import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserInfo> queryUserInfo() {
        List<UserInfo> res = userInfoService.queryUserInfo();

        return res;
    }

    /**
     * 登录账号
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String  password){
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return "login request message failure";
        }
        UserInfo userInfo = userInfoService.getUserInfo(userName, password);
        return userInfo.toString();
    }
}
