package com.ssm.entity;

import com.ssm.entity.base.Cart;
import com.ssm.entity.base.Goods;
import lombok.Data;

@Data
public class CartAndGoods {
    private Cart cart;
    private Goods goods;
    private double smallsum; //订单价格
}
