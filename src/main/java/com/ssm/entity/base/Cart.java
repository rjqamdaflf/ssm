package com.ssm.entity.base;


import lombok.Data;

@Data
public class Cart {
    private int id;    //购物车ID
    private int buser_id;   //用户ID
    private int goods_id;  //商品编号
    private int shoppingnum; //购买数量
}
