package com.ssm.service.base.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.CartAndGoods;
import com.ssm.entity.base.Cart;
import com.ssm.entity.base.Focus;
import com.ssm.service.BaseService;
import com.ssm.service.base.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl extends BaseService implements CartService {


    public JSONObject focus(Focus focus) {
        //关注商品
        JSONObject json = new JSONObject();
        List<Focus> list = focusDao.isFocus(focus);
        if (list.size() > 0) {
            json.put("msg", "已关注该商品！");
        } else {
            int n = focusDao.insert(focus);
            if (n > 0)
                json.put("msg", "成功关注该商品！");
            else
                json.put("msg", "关注失败！");
        }
        return json;
    }

    public int putCart(Cart cart) {
        int store = goodsDao.selectGstore(cart.getGoods_id());
        if (store < cart.getShoppingnum())
            return -1; //库存不足
        //是否已添加购物车
        List<Cart> list = cartDao.isPutCart(cart);
        if (list.size() > 0)
            return cartDao.update(cart);
        else
            return cartDao.insert(cart);
    }

    public JSONObject selectCart(Integer id) {
        List<CartAndGoods> list = cartDao.selectCart(id);
        double sum = 0;
        for (CartAndGoods cartAndGoods : list) {
            sum = sum + cartAndGoods.getSmallsum();
        }
        JSONObject json = new JSONObject();
        json.put("total", sum);
        json.put("cartlist", list);
        return json;
    }


    public int deleteAgoods(Integer userID, Integer goodsID) {
        return cartDao.delete(userID, goodsID);
    }

    public int clear(Integer userID) {
        return cartDao.clear(userID);
    }
}
