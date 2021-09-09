package com.muscleape.influxdb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Muscleape
 * @Date: 2019-09-10
 * @Description:
 */

@Configuration
@Slf4j
public class InfluxDBConfiguration {

    @Autowired
    private InfluxDBProperties influxDBProperties;

    @Bean
    public InfluxDBConnect getInfluxDBConnect() {
        InfluxDBConnect influxDB = new InfluxDBConnect(influxDBProperties.getUserName(), influxDBProperties.getPassword(),
                influxDBProperties.getUrl(), influxDBProperties.getDatabase(), influxDBProperties.getRetentionPolicy(),
                influxDBProperties.getRetentionPolicyTime());

        influxDB.influxDbBuild();

        influxDB.createRetentionPolicy();
        log.info("init influxdb::[{}]", influxDBProperties);
        return influxDB;
    }
}
