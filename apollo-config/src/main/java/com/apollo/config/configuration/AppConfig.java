package com.apollo.config.configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2021-12-17 14:44
 * @description: 项目配置类
 **/
@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public TestJavaConfigBean javaConfigBean() {
        return new TestJavaConfigBean();
    }
}
