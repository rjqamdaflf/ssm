package com.ssm.entity.base;


import lombok.Data;

@Data
public class Order {

    private Integer id; //订单编号（PK自增）
    private Integer busertable_id;  //用户ID（FK）
    private Double amount;  //订单金额
    private Integer status;  //订单状态
    private String orderdate;  //下单时间
}
