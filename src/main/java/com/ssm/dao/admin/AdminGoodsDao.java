package com.ssm.dao.admin;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminGoodsDao extends CrudDao<Goods> {


    public int deleteListById(List<Integer> ids);

    @Deprecated
    public List<Goods> findAllListByPage();

    public Map<String, Goods> selectCartGoods(Integer id);

    public Map<String, Goods> selectFocusGoods(Integer id);

    public Map<String, Goods> selectOrderdetailGoods(Integer id);
}
