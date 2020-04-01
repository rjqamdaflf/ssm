package com.ssm.entity;

import com.ssm.entity.base.Focus;
import com.ssm.entity.base.Goods;
import lombok.Data;

@Data
public class FocusAndGoods extends Focus {
    private Goods goods;

}
