package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.FocusAndGoods;
import com.ssm.entity.base.Focus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FocusDao extends CrudDao<Focus> {
    public List<Focus> selectFocusGoodsByGoodsId(Integer id);

    public List<FocusAndGoods> myFocus(Integer id);

    public List<Focus> isFocus(Focus focus);

    public List<Map<String, Object>> getFocusOrder();

}
