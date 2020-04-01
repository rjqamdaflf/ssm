package com.ssm.entity.base;

import lombok.Data;

@Data
public class OrderDetail {
    private int id;   //订单编号（PK自增）
    private int orderbasetable_id;  //订单编号（FK）
    private int goodstable_id;  //商品编号（FK)
    private int shoppingnum;  //购买数量
}
