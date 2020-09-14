package com.neusoft.mpc.authapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siss
 * @date 2020/8/19  9:33
 */
@RestController
@RequestMapping("/test")
public class RequestTestController {

    @GetMapping(value = "/first")
    public String test () {
        return "request success";
    }
}
