package com.ssm.dao.admin;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Auser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDao extends CrudDao<Auser> {

}
