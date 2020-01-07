package com.order.classes.mapper;

import com.order.classes.pojo.Cuisine;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassesMapper {
    //添加菜品类型，方法已测
    @Insert("INSERT INTO class (cid,cnumber,cname,beiyong1) VALUES (#{cid},#{cnumber},#{cname},#{beiyong1})")
    public int addClasses(Cuisine cuisine);
    //删除菜品类型，方法已测
    @Delete("DELETE FROM class where cid=#{cid}")
    public  int delClasses(@Param("cid")Integer cid);
    //修改菜品类型，方法已测
    @Update("UPDATE class SET cnumber=#{cnumber},cname=#{cname},beiyong1=#{beiyong1} WHERE cid=#{cid}")
    public  int updateClasses(Cuisine cuisine);
    //查询全部类型信息，方法已测(应该加上分页)
    @Select("SELECT cid,cnumber,cname,classcreate,classupdate,beiyong1 FROM class")
    public List<Cuisine> queryCuisine();
    //按照CID查询类型信息，方法已测
    @Select("SELECT cid,cnumber,cname,classcreate,classupdate,beiyong1 FROM class WHERE cid=#{cid}")
    public Cuisine queryCuisineById(@Param("cid")Integer cid);
    //按照Cnumber查询类型信息，方法已测
    @Select("SELECT cid,cnumber,cname,classcreate,classupdate FROM class WHERE cnumber=#{cnumber}")
    public Cuisine queryCuisineByNumber(@Param("cnumber")Integer cnumber);
    //获取总记录数
    @Select("select count(1) from class")
    public int queryCount();

     /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品类型分页查询（带查询条件）
     */
     @Select("SELECT cid,cnumber,cname,classcreate,classupdate,beiyong1 FROM class limit #{page},#{pageSize}")
     public List<Cuisine> findClasses(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

}
