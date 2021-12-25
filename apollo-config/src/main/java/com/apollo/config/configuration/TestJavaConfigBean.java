package com.apollo.config.configuration;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2021-12-17 14:43
 * @description: 配置类
 **/
public class TestJavaConfigBean {

    @Value("${timeout:100}")
    private int timeout;
    private int batch;

    @Value("${batch:200}")
    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }
}
