package com.order.orderings.mapper;

import com.order.orderings.pojo.Ordering;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderingsMapper {

    //将订单信息添加至订单主表，已测
    @Insert("insert into ordering (oid,uid,bname,bphone,address,amount) values (#{oid},#{uid},#{bname},#{bphone},#{address},#{amount})")
    public int addOrdering(Ordering ordering);

    //创建一个订单[有关事务处理],通过测试
    public Ordering create(Ordering ordering);

    //取消一个订单[有关事务处理],通过测试
    @Update("update ordering set orderstatus=2 where oid=#{oid}")
    public int cancel(Ordering ordering);

    //支付订单,此方法已经测试
    @Update("update ordering set pay=1 where oid=#{oid}")
    public int pay(Ordering ordering);

    //完结订单,此方法已通过测试(卖家后端进行操作)
    @Update("update ordering set orderstatus=1 where oid=#{oid}")
    public int finish(Ordering ordering);

    //根据订单id查询单个订单，包括订单详情；已测
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering where oid=#{oid}")
    public Ordering findone(String oid);

    //查询此用户所有已完成订单列表（应该加分页），已测,但没有详情信息的订单项也查出来了，如何处理类；
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering where uid=#{uid}")
    public List<Ordering> findAll(Integer uid);

    //查询所有订单
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering")
    public List<Ordering> queryAll();

    //带条件查询订单
    public List<Ordering> queryAllBy(@Param("start") Integer start, @Param("size") Integer size, @Param("keyword") String keyword);

    //带条件总记录数
    public int count(@Param("keyword") String keyword);

    //查询当月营业额
    @Select("SELECT SUM(amount) FROM ordering WHERE MONTH(createtime)=#{month} AND pay=0")
    public Integer SumTotal(@Param("month") Integer month);

    //查询个人点单
    @Select("select oid,uid,bname,bphone,address,amount,pay,orderstatus,createtime,updatetime from ordering where uid=#{uid}")
    public List<Ordering> findone2(Integer uid);
}
