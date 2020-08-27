package com.rocketmq.example.rocketmq.message;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author siss
 * @date 2020/8/27  10:05
 */
public class MessageListener implements MessageListenerConcurrently {

    @Autowired
    private MessageProcessor messageProcessor;

    public void setMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt messageExt = list.get(0);
        boolean handle = messageProcessor.handle(messageExt);
        if (!handle) {
            // 重试
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        // 成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
