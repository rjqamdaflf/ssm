package com.ssm.service.base;

import com.ssm.entity.GoodsAndOrderDetail;
import com.ssm.entity.base.Order;
import com.ssm.entity.base.OrderAndBUser;

import java.util.List;
import java.util.Map;

public interface OrderService {

    // 获取热销产品
    public List<Map<String, Object>> getSaleOrder();

    //提交订单
    public int orderSubmit(int userId);

    //付款
    public String pay(Integer ordersn);

    //查询用户所有订单
    public List<Order> myOrder(Integer id);

    //用户订单详细
    public List<GoodsAndOrderDetail> orderDetail(Integer ordersn);

    public List<OrderAndBUser> orderInfo();

}
