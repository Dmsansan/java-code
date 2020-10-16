package com.sansan.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author siss
 * @date 2020/10/16  10:48
 */
@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

    @Autowired
    MongoTemplate mongoTemplate;
}
