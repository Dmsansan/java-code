package com.rocketmq.example.rocketmq.message.impl;

import com.rocketmq.example.entity.Panda;
import com.rocketmq.example.rocketmq.message.MessageProcessor;
import org.springframework.stereotype.Service;

/**
 * @author siss
 * @date 2020/8/27  13:55
 */
@Service
public class AnimalMessageProcessorImpl implements MessageProcessor<Panda> {

    @Override
    public boolean handleMessage(Panda message) {
        System.out.println("animal receive:" + message.toString());
        return true;
    }

    @Override
    public Class<Panda> getClazz() {
        return Panda.class;
    }
}
