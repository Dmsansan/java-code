package sansan.kafka.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author siss
 * @date 2020/7/1  10:32
 */
public class SimpleConsumerListener {

    private final static Logger logger = LoggerFactory.getLogger(SimpleConsumerListener.class);
    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "topic-test")
    public void listen(String records) {
        //do something here
        System.out.println("消费端接收到的消息:"+records);
        this.latch1.countDown();
    }
}
