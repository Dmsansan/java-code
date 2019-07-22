package com.sansan.springboot.api.mapper;

import com.sansan.springboot.api.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {

    List<UserInfo> queryUserInfo();
}
