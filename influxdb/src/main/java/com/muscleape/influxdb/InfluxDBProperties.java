package com.muscleape.influxdb;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Muscleape
 * @Date: 2019-09-24
 * @Description:
 */

@Configuration
@ConfigurationProperties(prefix = "spring.influx")
@Data
public class InfluxDBProperties {


    @URL
    private String url;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String database;
    @NotBlank
    private String retentionPolicy;
    @NotBlank
    private String retentionPolicyTime;

}
