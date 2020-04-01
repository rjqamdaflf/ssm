package com.ssm.service.base;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.GoodsAndType;
import com.ssm.entity.GoodsType;
import com.ssm.entity.base.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public int addType(GoodsType type);

    public int deleteType(Integer id);

    public JSONObject getAllType();

    public boolean addOrUpdateGoods(Goods goods, String path, String act);

    public JSONObject selectGoods(Integer pageCur);

    public GoodsAndType selectAGoods(Integer id);

    public List<GoodsType> selectAllGoodType();

    Object selectGoodsById(Integer id);

    public List<Goods> search(String mykey);

    public List<Map<String, Object>> getLastedGoods(Goods goods);

    public JSONObject deleteAGoods(Integer id);


}
