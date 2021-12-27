package com.apollo.config.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2021-12-14 09:23
 * @description: 首页控制类
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    private String timeout;

    @ApolloConfig
    private Config config;

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels();
    }

    @PostConstruct
    private void refreshLoggingLevels() {
        Set<String> keyNames = config.getPropertyNames();
        for (String key : keyNames) {
            timeout = config.getProperty(key, "info");
        }
    }

    /**
     * 获取动态配置
     *
     * @return string
     */
    @RequestMapping(value = "/getConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String dynamicApolloConfig() {
        try {
            return timeout;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
