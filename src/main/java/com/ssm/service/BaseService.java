package com.ssm.service;

import com.ssm.dao.base.*;
import com.ssm.dao.before.IndexDao;

import javax.annotation.Resource;

public class BaseService {
    @Resource
    public AuserDao auserDao;
    @Resource
    public BuserDao buserDao;
    @Resource
    public CartDao cartDao;
    @Resource
    public FocusDao focusDao;
    @Resource
    public GoodsDao goodsDao;
    @Resource
    public GoodsTypeDao goodsTypeDao;
    @Resource
    public NoticeDao noticeDao;
    @Resource
    public OrderDao orderDao;
    @Resource
    public OrderDetailDao orderDetailDao;

    @Resource
    public IndexDao indexDao;

}
