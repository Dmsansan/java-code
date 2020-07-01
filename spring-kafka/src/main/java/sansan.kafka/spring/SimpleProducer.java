package sansan.kafka.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import sansan.kafka.spring.config.KafkaConfig;

import java.util.concurrent.ExecutionException;

/**
 * @author siss
 * @date 2020/7/1  10:31
 */
public class SimpleProducer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);
        KafkaTemplate<Integer, String> kafkaTemplate = (KafkaTemplate<Integer, String>) ctx.getBean("kafkaTemplate");
        String data="this is a test message";
        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("topic-test", 1, data);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {

            }
        });
    }
}
