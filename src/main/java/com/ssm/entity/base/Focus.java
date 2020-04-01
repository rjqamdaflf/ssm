package com.ssm.entity.base;

import lombok.Data;

@Data
public class Focus {
    private int id;   //ID
    private int goods_id;   //商品编号
    private int buser_id;   //用户id
    private String focustime; //关注时间
}
