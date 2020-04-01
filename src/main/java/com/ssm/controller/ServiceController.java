package com.ssm.controller;

import com.ssm.service.base.*;

import javax.annotation.Resource;

public class ServiceController {
    @Resource
    public AuserService auserService;
    @Resource
    public BuserService buserService;
    @Resource
    public CartService cartService;
    @Resource
    public FocusService focusService;
    @Resource
    public GoodsService goodsService;
    @Resource
    public NoticeService noticeService;
    @Resource
    public OrderService orderService;
}
