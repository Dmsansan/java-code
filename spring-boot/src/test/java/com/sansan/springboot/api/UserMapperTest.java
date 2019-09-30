package com.sansan.springboot.api;


import com.sansan.springboot.api.entity.UserInfo;
import com.sansan.springboot.api.mapper.UserInfoMapper;
import com.sansan.springboot.api.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = ApiManagerApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() {
        List<UserInfo> userInfos = userInfoService.queryUserInfo();

        System.out.println(userInfos.toString());
    }
}
