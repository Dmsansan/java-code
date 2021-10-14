package com.sansan.mycat.controller;

import com.sansan.mycat.entity.User;
import com.sansan.mycat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author siss
 * @date 2020/11/10  16:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/save")
    public String save(User user) {
        userMapper.insert(user);
        return "保存成功";
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userMapper.selectAll();
    }
}
