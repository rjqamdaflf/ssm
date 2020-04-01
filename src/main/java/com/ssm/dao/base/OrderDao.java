package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Order;
import com.ssm.entity.base.OrderAndBUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderDao extends CrudDao<Order> {
    public List<Order> myOrder(Integer id);

    public List<OrderAndBUser> orderInfo();


    public int addOrder(Order order);

    public int addOrderDetail(Map<String, Object> map);

    public List<Map<String, Object>> selectGoodsShop(Integer uid);

    public int updateStore(Map<String, Object> map);

    public int clear(Integer uid);

    public int pay(Integer ordersn);

    public List<Map<String, Object>> getSaleOrder();

    public double selectAmount(int userId);


}
