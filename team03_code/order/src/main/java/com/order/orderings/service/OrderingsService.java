package com.order.orderings.service;

import com.order.orderings.pojo.Ordering;

import java.util.List;

public interface OrderingsService {

    //创建一个订单
    public Ordering create(Ordering ordering);

    //取消一个订单
    public Ordering cancel(Ordering ordering);

    //支付订单
    public int pay(Ordering ordering);

    //查询单个订单
    public Ordering findone(Integer oid);

    //查询此用户所有已完成订单列表
    public List<Ordering> findAll(Integer uid);
}
