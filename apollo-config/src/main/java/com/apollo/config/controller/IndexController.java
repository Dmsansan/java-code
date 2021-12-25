package com.apollo.config.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2021-12-14 09:23
 * @description: 首页控制类
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    /**
     * 获取动态配置
     *
     * @return string
     */
    @RequestMapping(value = "/getConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String dynamicApolloConfig() {
        try {
            String properties = "test";
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
