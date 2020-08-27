package com.rocketmq.example.exception;

/**
 * @author siss
 * @date 2020/8/27  14:01
 */
public class RocketMQException extends RuntimeException {

    public RocketMQException(String message){
        super(message);
    }
}
