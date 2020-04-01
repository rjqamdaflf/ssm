package com.ssm.entity;

import com.ssm.entity.base.Goods;
import lombok.Data;

@Data
public class GoodsAndType extends Goods {
    private GoodsType goodsType;

}
