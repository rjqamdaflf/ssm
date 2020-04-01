package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.GoodsAndOrderDetail;
import com.ssm.entity.base.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailDao extends CrudDao<OrderDetail> {

    public List<OrderDetail> selectOrderdetailGoodsByGoodsId(Integer id);

    public List<GoodsAndOrderDetail> orderDetail(Integer ordersn);
}
