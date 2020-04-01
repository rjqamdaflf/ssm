package com.ssm.dao;

import java.util.List;


public interface CrudDao<T> {

    //获取单条数据
    public T selectOne(Integer id);

    //查询所有数据列表
    public List<T> selectAll();

    //插入数据
    public int insert(T entity);

    //更新数据
    public int update(T entity);

    //删除数据
    public int delete(Integer id);


}
