package com.sansan.springboot.api.mapper;

import com.sansan.springboot.api.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> queryUserInfo();

    UserInfo getUserInfo(HashMap<String, Object> params);
}
