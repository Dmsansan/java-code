package com.rocketmq.example.rocketmq.message;

import com.rocketmq.example.utils.JsonUtil2;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author siss
 * @date 2020/8/27  9:56
 */
public interface MessageProcessor<T> {

    boolean handleMessage(T message);

    Class<T> getClazz();

    default T transferMessage(String message) {
        return JsonUtil2.fromJson(message, getClazz());
    }
}
