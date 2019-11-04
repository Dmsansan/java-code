package com.sansan.springboot.api.controller;

import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

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
    public String login(HttpServletRequest request, @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String  password){
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return "login request message failure";
        }
        UserInfo userInfo = userInfoService.getUserInfo(userName, password);
        if(userInfo != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", userInfo.getId());
            redisTemplate.opsForValue().set("loginUser:" + userInfo.getId(), session.getId());
            return userInfo.toString();
        }else{
            return "用户不存在";
        }
    }
}
