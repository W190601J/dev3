package com.order.orderings.service;

import com.order.orderings.mapper.OrderingsMapper;
import com.order.orderings.pojo.Ordering;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderingsService {

    //将信息插入订单主表
    public int addOrdering(Ordering ordering);

    //创建一个订单
    public Ordering create(Ordering ordering);

    //取消一个订单
    public int cancel(Ordering ordering);

    //支付订单
    public int pay(Ordering ordering);

    //完结订单
    public int finish(Ordering ordering);

    //查询单个订单
    public Ordering findone(String oid);

    //查询此用户所有已完成订单列表
    public List<Ordering> findAll(Integer uid);

    //查询所有订单
    public List<Ordering> queryAll();

    //条件查询订单
    public List<Ordering> queryAllBy(Integer page, Integer pageSize, String keyword);

    //条件查询总记录数
    public int count(String keyword);

    //查询当月营业额
    public Integer SumTotal(Integer month);

    public List<Ordering> findone2(Integer uid);
}
