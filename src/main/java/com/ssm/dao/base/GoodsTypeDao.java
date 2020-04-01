package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GoodsTypeDao extends CrudDao<GoodsType> {
}
