package com.ssm.service.base.impl;

import com.ssm.entity.GoodsAndOrderDetail;
import com.ssm.entity.base.Order;
import com.ssm.entity.base.OrderAndBUser;
import com.ssm.service.BaseService;
import com.ssm.service.base.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl extends BaseService implements OrderService {

    public List<Map<String, Object>> getSaleOrder() {
        return orderDao.getSaleOrder();
    }


    /**
     * 订单提交，连续的事务处理
     */
    public int orderSubmit(int userId) {
        //获取用户所有购物车商品总金额

        Order order = new Order();
        order.setAmount(orderDao.selectAmount(userId));
        order.setBusertable_id(userId);
        //生成订单，并将主键返回order
        orderDao.addOrder(order);

        System.out.println(order);

        //生成订单详情
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ordersn", order.getId());
        map.put("uid", userId);
        orderDao.addOrderDetail(map);
        //更新商品库存
        //1.查询商品购买量，以便更新库存使用
        List<Map<String, Object>> list = orderDao.selectGoodsShop(userId);
        //2.根据商品购买量更新库存
        for (Map<String, Object> map2 : list) {
            orderDao.updateStore(map2);
        }
        //清空购物车
        orderDao.clear(userId);
        return order.getId();
    }

    public String pay(Integer ordersn) {
        orderDao.pay(ordersn);
        return "before/paydone";
    }

    public List<Order> myOrder(Integer id) {
        return orderDao.myOrder(id);
    }

    public List<GoodsAndOrderDetail> orderDetail(Integer ordersn) {
        return orderDetailDao.orderDetail(ordersn);
    }

    public List<OrderAndBUser> orderInfo() {
        return orderDao.orderInfo();
    }


}
