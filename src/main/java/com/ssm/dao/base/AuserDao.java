package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Auser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuserDao extends CrudDao<Auser> {
    public List<Auser> login(Auser auser);

    public int count();
}
