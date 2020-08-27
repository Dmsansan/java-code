package com.sansan.cn.weather.authapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siss
 * @date 2020/8/19  9:33
 */
@RestController
@RequestMapping("/test")
public class RequestTestController {

    @RequestMapping(value = "/first", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test () {
        return "request success";
    }
}
