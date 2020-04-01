package com.ssm.dao.before;

import com.ssm.entity.base.Goods;

import java.util.List;
import java.util.Map;

public interface IndexDao {

    public List<Map<String, Object>> getSaleOrder();

    public List<Map<String, Object>> getFocusOrder();

    public List<Map<String, Object>> selectNotice();

    public List<Map<String, Object>> getLastedGoods(Goods goods);

    public Goods selectGoodsById(Integer id);

    public List<Goods> search(String mykey);
}
