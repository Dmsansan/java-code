package com.sansan.springboot.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemResource {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String sayHello(){
        return "welcome to spring boot project";
    }
}
