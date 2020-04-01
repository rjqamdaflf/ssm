package com.ssm.dao.base;

import com.ssm.dao.CrudDao;
import com.ssm.entity.base.Buser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BuserDao extends CrudDao<Buser> {

    public List<Buser> login(Buser buser);

    public List<Buser> getUserByEmail(String email);
}
