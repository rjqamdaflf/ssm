package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Cart;
import com.ssm.entity.CartAndGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartDao extends CrudDao<Cart> {


    //传入用户userId 和 goodsId
    public int delete(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    public List<Cart> selectCartGoodsByGoodsId(Integer id);

    //传入用户id
    public List<CartAndGoods> selectCart(Integer userId);

    public List<Cart> isPutCart(Cart cart);

    public int clear(Integer userID);


}
