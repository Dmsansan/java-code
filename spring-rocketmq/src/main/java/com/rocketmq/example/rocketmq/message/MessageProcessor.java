package com.rocketmq.example.rocketmq.message;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author siss
 * @date 2020/8/27  9:56
 */
public interface MessageProcessor {

    boolean handle(MessageExt messageExt);
}
