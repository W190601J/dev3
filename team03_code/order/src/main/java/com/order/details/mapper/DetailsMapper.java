package com.order.details.mapper;

import com.order.details.pojo.Detail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DetailsMapper {

    //插入详情表，已测
    @Insert("insert into details (fid,oid,dname,dprice,dphoto,quantity) values (#{fid},#{oid},#{dname},#{dprice},#{dphoto},#{quantity})")
    public int detailsAdd(Detail detail);

    //根据oid查询这个订单的所有订购商品，已测
    @Select("select did,fid,oid,dname,dprice,dphoto,quantity from details where oid=#{oid}")
    public List<Detail> findAll(String oid);

    //查询当月菜品的销售量
    @Select("SELECT SUM(b.quantity)FROM ordering a LEFT JOIN details b ON a.oid=b.oid WHERE DATE_FORMAT(a.createtime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND b.fid=#{fid}")
    public int Sum(@Param("fid")Integer fid);

    //查询当月菜品的销售量
    @Select("SELECT SUM(b.dprice)FROM ordering a LEFT JOIN details b ON a.oid=b.oid WHERE DATE_FORMAT(a.createtime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )  AND a.pay=0 ")
    public int SumTotal(@Param("month") Integer month);
}
