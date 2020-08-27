package com.rocketmq.example.rocketmq.message.impl;

import com.rocketmq.example.entity.User;
import com.rocketmq.example.rocketmq.message.MessageProcessor;
import org.springframework.stereotype.Service;

/**
 * @author siss
 * @date 2020/8/27  9:58
 */
@Service
public class UserMessageProcessorImpl implements MessageProcessor<User> {

    @Override
    public boolean handleMessage(User user) {
        System.out.println("user receive : " + user.toString());
        return true;
    }

    @Override
    public Class<User> getClazz() {
        return User.class;
    }
}
