package com.rocketmq.example.rocketmq.message.impl;

import com.rocketmq.example.rocketmq.message.MessageProcessor;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * @author siss
 * @date 2020/8/27  9:58
 */
@Service
public class MessageProcessorImpl implements MessageProcessor {

    @Override
    public boolean handle(MessageExt messageExt) {
        String s = new String(messageExt.getBody());
        System.out.println("接收到的消息："+s);
        return true;
    }
}
