package com.sansan.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author siss
 * @date 2020/10/16  11:05
 */
@Data
public class Order {
    /**
     * 订单id
     */
    private int id;
    /**
     * 状态
     */
    private String status;
    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date orderTime;
    /**
     * 发货人
     */
    private String shipper;
    /**
     * 发货地址
     */
    private String shippingAdress;
    /**
     * 发货人手机
     */
    private long shipperPhone;
    /**
     * 发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date shipTime;
    /**
     * 接收人
     */
    private String recevier;
    /**
     * 接收地址
     */
    private String recevierAddress;
    /**
     * 接收人号码
     */
    private long receviePhone;
    /**
     * 物流信息
     */
    private List<Logistics> logistics;

    public Order(int id, String status, Date orderTime, String shipper, String shippingAdress, long shipperPhone, Date shipTime, String recevier, String recevierAddress, long receviePhone, List<Logistics> logistics) {
        this.id = id;
        this.status = status;
        this.orderTime = orderTime;
        this.shipper = shipper;
        this.shippingAdress = shippingAdress;
        this.shipperPhone = shipperPhone;
        this.shipTime = shipTime;
        this.recevier = recevier;
        this.recevierAddress = recevierAddress;
        this.receviePhone = receviePhone;
        this.logistics = logistics;
    }
}
