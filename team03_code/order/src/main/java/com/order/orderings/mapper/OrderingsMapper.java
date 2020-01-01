package com.order.orderings.mapper;

import com.order.orderings.pojo.Ordering;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderingsMapper {

    //将订单信息添加至订单主表，已测
    @Insert("insert into ordering (oid,uid,bname,bphone,address,amount) values (#{oid},#{uid},#{bname},#{bphone},#{address},#{amount})")
    public int addOrdering(Ordering ordering);

    //创建一个订单[有关事务处理]
    public Ordering create(Ordering ordering);

    //取消一个订单[有关事务处理]
    public Ordering cancel(Ordering ordering);

    //支付订单
    public int pay(Ordering ordering);

    //根据订单id查询单个订单，已测
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering where oid=#{oid}")
    public Ordering findone(String oid);

    //查询此用户所有已完成订单列表（应该加分页），已测
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering where uid=#{uid}")
    public List<Ordering> findAll(Integer uid);


}
