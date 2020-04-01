package com.ssm.entity;

import com.ssm.entity.base.Goods;
import com.ssm.entity.base.OrderDetail;
import lombok.Data;

@Data
public class GoodsAndOrderDetail {

    private Goods goods;
    private OrderDetail orderDetail;
}
