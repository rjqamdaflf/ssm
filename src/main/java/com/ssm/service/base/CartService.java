package com.ssm.service.base;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.base.Cart;
import com.ssm.entity.base.Focus;

public interface CartService {


    public JSONObject focus(Focus focus);

    public int putCart(Cart cart);

    public JSONObject selectCart(Integer id);

    public int deleteAgoods(Integer userID, Integer goodsID);

    public int clear(Integer userID);
}
