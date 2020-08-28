package sansan.kafka.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author siss
 * @date 2020/6/29  14:13
 * @desc kafka消息的生产者
 */
public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "124.70.154.139:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>("topic-test", Integer.toString(i), Integer.toString(i)));
        }

        producer.close();
    }
}
