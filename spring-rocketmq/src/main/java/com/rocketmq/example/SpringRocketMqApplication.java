package com.rocketmq.example;

import com.alibaba.fastjson.JSON;
import com.rocketmq.example.entity.Panda;
import com.rocketmq.example.entity.User;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author neusoft
 */
@SpringBootApplication
public class SpringRocketMqApplication {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        ApplicationContext context = SpringApplication.run(SpringRocketMqApplication.class, args);
        DefaultMQProducer producer = context.getBean(DefaultMQProducer.class);
        User user  = new User("茜茜",18,"女");
        Message message = new Message("topic2020", "test", JSON.toJSONString(user).getBytes());
        SendResult result = producer.send(message);
        System.out.println("发送了消息" + result);

        Panda panda = new Panda("虎子", 5);
        Message pandaMessage = new Message("animal", "panda", JSON.toJSONString(panda).getBytes());
        SendResult animalResult =  producer.send(pandaMessage);
        System.out.println("发送了消息" +animalResult );

        producer.shutdown();
        System.out.println("producer shutdown!");
    }
}
