package com.sansan.order.controller;

import com.sansan.order.pojo.Logistics;
import com.sansan.order.pojo.Order;
import com.sansan.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author siss
 * @date 2020/10/16  10:46
 */
@RequestMapping(value = "/order")
@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/addOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addOrder(Order order)
    {
        order.setStatus("发货中");
        order.setOrderTime(new Date());
        order.setShipTime(new Date());
        orderService.addOrder(order);
        return "添加成功";
    }

    /**
     * 更新物流状态
     *
     * @param logistics
     * @return
     */
    @PostMapping(value = "/updateOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateOrder(Logistics logistics)
    {
        logistics.setOperationTime(new Date());
        orderService.addLogisticsAndUpdateStatus(logistics);
        return "更新成功";
    }

    /**
     * 查询订单信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "getOrderById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById(int id)
    {
        Order order=orderService.getOrderById(id);
        return  order;
    }
}
