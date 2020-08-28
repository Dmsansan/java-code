package sansan.kafka.spring.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import sansan.kafka.spring.SimpleConsumerListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siss
 * @date 2020/7/1  10:22
 * @desc 以spring-kafka的方式使用kafka软件服务
 *       配置对应的topic、consumer、producer
 */
@Configuration
@EnableKafka
public class KafkaConfig {

    /**
     * topic bean
     *
     * @return
     */
    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "124.70.154.139:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("foo", 10, (short) 2);
    }

    /**
     * producer bean
     * @return
     */
    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<Integer, String>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "124.70.154.139:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    /**
     * consumer bean
     * @return
     */
    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<Integer, String>(producerFactory());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer,String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<Integer, String>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer,String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<Integer, String>(consumerConfigs());
    }


    @Bean
    public Map<String,Object> consumerConfigs(){
        HashMap<String, Object> props = new HashMap<String, Object>();
        props.put("bootstrap.servers", "124.70.154.139:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    @Bean
    public SimpleConsumerListener simpleConsumerListener(){
        return new SimpleConsumerListener();
    }
}
