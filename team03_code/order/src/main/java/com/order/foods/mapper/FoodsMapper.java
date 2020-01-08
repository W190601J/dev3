package com.order.foods.mapper;

import com.order.foods.pojo.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FoodsMapper {
    //添加菜品信息,方法已测
    @Insert("INSERT INTO food (fid,fname,cnumber,price,fphoto,finfo,cstock) VALUES (#{fid},#{fname},#{cnumber},#{price},#{fphoto},#{finfo},#{cstock})")
    public int addFood(Food food);

    //删除菜品信息,方法已测
    @Delete("DELETE FROM food where fid=#{fid}")
    public int delFood(@Param("fid")Integer fid);

    //修改菜品信息(需用动态SQL语句)
    @Update("UPDATE food SET fname=#{fname},cnumber=#{cnumber},price=#{price},fphoto=#{fphoto},finfo=#{finfo},fsell=#{fsell},cstock=#{cstock},fstatus=#{fstatus} WHERE fid=#{fid} ")
    public int updateFood(Food food);

    //查询全部菜品信息(需加上分页)，已测试
    @Select("SELECT fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus,fcreate,fupdate FROM food where cnumber=#{cnumber} limit #{start},#{size}")
    public List<Food> queryFood(@Param("cnumber") Integer cnumber,@Param("start") Integer start, @Param("size") Integer size);

    //按照菜品id查询菜品信息,已测试
    @Select("SELECT fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus,fcreate,fupdate FROM food WHERE fid=#{fid}")
    public Food queryFoodById(@Param("fid")Integer fid);

    //根据菜品的状态查询所有已上架菜品（买家端）,方法已测
    @Select("select fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus from food where fstatus=0")
    public List<Food> queryFoodByStatus();

    //加库存,方法已测
    @Update("update food set cstock=cstock+#{number} where fid=#{fid}")
    public int addStock(@Param("fid") Integer fid,@Param("number") Integer number);

    //减库存,方法已测
    @Update("update food set cstock=cstock-#{number} where fid=#{fid}")
    public int reduceStock(@Param("fid")Integer fid,@Param("number") Integer number);

    //更新菜品销量信息
    @Update("update food set fsell=fsell+#{number} where fid=#{fid}")
    public int addsells(@Param("fid")Integer fid,@Param("number") Integer number);

    //上下架菜品,方法已测
    public int sold(@Param("fstatus")Integer fstatus,@Param("fid")Integer fid);

    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品分页查询（带查询条件）
     */
    @Select("SELECT fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus,fcreate,fupdate FROM food where cnumber=#{cnumber} limit #{start},#{size}")
    public List<Food> findFood(@Param("cnumber") Integer cnumber,@Param("start") Integer start, @Param("size") Integer size);
    //获得总记录数，需要区分菜式
    @Select("SELECT count(1) FROM food where cnumber=#{cnumber}")
    public int querytt(@Param("cnumber")Integer cnumber);


    //根据菜品的状态查询所有已上架菜品（买家端）,方法已测
    @Select("select fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus from food ")
    public List<Food> queryFid();
}
