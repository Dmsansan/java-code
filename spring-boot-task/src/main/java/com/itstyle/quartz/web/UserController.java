package com.itstyle.quartz.web;

import com.itstyle.quartz.entity.Result;
import com.itstyle.quartz.entity.UserEntity;
import com.itstyle.quartz.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author siss
 * @date 2020/9/28  10:25
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private IUserService iUserService;

    /**
     * 用户注册
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/registry")
    public Result save(@RequestBody UserEntity userEntity) {
        LOGGER.info("用户注册");
        if (StringUtils.isEmpty(userEntity.getUserName())
                || StringUtils.isEmpty(userEntity.getPassWord())) {
            return Result.error(500, "缺少必要参数");
        }

        userEntity.setCreateDate(new Date());
        iUserService.save(userEntity);
        return Result.ok();
    }

    /**
     * 用户登录
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody UserEntity userEntity){
        LOGGER.info("用户登录");
        if (StringUtils.isEmpty(userEntity.getUserName())
                || StringUtils.isEmpty(userEntity.getPassWord())) {
            return Result.error(500, "缺少必要参数");
        }

        int count = iUserService.queryCount(userEntity);
        if (count == 0 ) {
            return Result.error(1, "用户不存在，请注册");
        }

        List<UserEntity> list = iUserService.queryListByObject(userEntity);
        if (list.size() == 0) {
            return Result.error(2, "用户密码不正确");
        }
        return Result.ok(list);
    }
}
