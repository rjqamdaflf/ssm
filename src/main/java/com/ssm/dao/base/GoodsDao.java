package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Goods;
import com.ssm.entity.GoodsAndType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsDao extends CrudDao<Goods> {
    public int count();

    //查询库存
    public int selectGstore(int goodsId);


    public List<Goods> search(String mykey);

    //分页查询
    public List<Goods> selectAllGoodsByPage(Map<String, Object> map);

    public List<Goods> selectOrderdetailGoodsByGoodsId(Integer id);

    //级联查询，获取type名称
    public GoodsAndType selectGoodsAndType(Integer id);

    public List<Map<String, Object>> getLastedGoods(Goods goods);



}
