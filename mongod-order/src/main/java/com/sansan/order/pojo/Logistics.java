package com.sansan.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author siss
 * @date 2020/10/16  11:05
 */
@Data
public class Logistics {
    /**
     * 订单id
     */
    private int orderId;

    /**
     * 操作
     */
    private String operation;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date operationTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注细节
     */
    private String details;

    public Logistics(){}
    public Logistics(int orderId, String operation, String operator, Date operationTime, String address, String details) {
        this.orderId = orderId;
        this.operation=operation;
        this.operator = operator;
        this.operationTime = operationTime;
        this.address = address;
        this.details = details;
    }
}
