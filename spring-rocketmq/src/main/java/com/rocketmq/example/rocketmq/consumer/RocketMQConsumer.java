package com.rocketmq.example.rocketmq.consumer;

import com.rocketmq.example.entity.User;
import com.rocketmq.example.exception.RocketMQException;
import com.rocketmq.example.rocketmq.message.MessageListener;
import com.rocketmq.example.rocketmq.message.MessageProcessor;
import com.rocketmq.example.rocketmq.message.impl.AnimalMessageProcessorImpl;
import com.rocketmq.example.rocketmq.message.impl.UserMessageProcessorImpl;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author siss
 * @date 2020/8/27  10:09
 */
@Component
public class RocketMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(RocketMQConsumer.class);

    @Autowired
    private UserMessageProcessorImpl messageProcessor;

    @Autowired
    private AnimalMessageProcessorImpl animalMessageProcessor;

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.groupName}")
    private String groupName;

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Value("${rocketmq.consumer.tag}")
    private String tag;

    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;

    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    @Value("${rocketmq.consumer.animal.tag}")
    private String animalTag;

    @Value("${rocketmq.consumer.animal.topic}")
    private String animalTopic;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer()
    {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setVipChannelEnabled(false);
        MessageListener messageListene = new MessageListener();
        //在监听类中增加两个消息处理类，当然可以增加更多，也就是往MessageListen类中的map集合放入处理类。
        messageListene.registerHandler(tag, messageProcessor);
        messageListene.registerHandler(animalTag,animalMessageProcessor);
        consumer.registerMessageListener(messageListene);
        try {
            consumer.subscribe(topic,this.tag);
            //这里需要多加一个设置。第二个参数是tag表示只会消费topic下面标签为tag的消息，如果是* 就表示会消费tapic下面所有的消息。
            consumer.subscribe(animalTopic,"*");
            consumer.start();
            log.info("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr);
        }catch (MQClientException e){
            log.error("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr,e);
            throw new RocketMQException(e.getMessage());
        }
        return consumer;
    }
}
