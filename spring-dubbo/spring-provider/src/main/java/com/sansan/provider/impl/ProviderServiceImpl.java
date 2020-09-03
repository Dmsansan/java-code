package com.sansan.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sansan.api.client.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author siss
 * @date 2020/9/2  14:01
 */
@Service(version = "1.0.0")
@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "hello" +name;
    }
}
