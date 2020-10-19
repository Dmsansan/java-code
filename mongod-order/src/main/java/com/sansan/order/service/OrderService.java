package com.sansan.order.service;

import com.sansan.order.pojo.Logistics;
import com.sansan.order.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author siss
 * @date 2020/10/16  10:48
 */
@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public void addOrder(Order order){
        mongoTemplate.insert(order, "order");
    }

    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        String status=logistics.getOperation();
        Query query = new Query(Criteria.where("_id").is(logistics.getOrderId()));
        Update update = new Update();
        // 更新状态
        update.set("status", status);
        update.push("logistics",logistics);
        mongoTemplate.upsert(query, update, Order.class);
    }

    public Order getOrderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Order order=mongoTemplate.findOne(query, Order.class);
        return order;
    }
}
