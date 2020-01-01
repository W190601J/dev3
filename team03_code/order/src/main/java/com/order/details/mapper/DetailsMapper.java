package com.order.details.mapper;

import com.order.details.pojo.Detail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DetailsMapper {

    //插入详情表，已测
    @Insert("insert into details (fid,oid,dname,dprice,dphoto,quantity) values (#{fid},#{oid},#{dname},#{dprice},#{dphoto},#{quantity})")
    public int detailsAdd(Detail detail);

    //根据oid查询这个订单的所有订购商品，已测
    @Select("select did,fid,oid,dname,dprice,dphoto,quantity from details")
    public List<Detail> findAll(String oid);


}
