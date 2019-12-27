package com.order.foods.mapper;

import com.order.foods.pojo.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FoodsMapper {
    //添加菜品信息
    @Insert("INSERT INTO food (fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus)VALUES(fname=#{fname},cnumber=#{cnumber},price=#{price},fphoto=#{fphoto},finfo=#{finfo},fsell=#{fsell},cstock=#{cstock},fstatus=#{fstatus})")
    public int addFood(Food food);
    //删除菜品信息
    @Delete("DELETE FROM food where fid=#{fid}")
    public int delFood(@Param("fid")Integer fid);
    //修改菜品信息
    @Update("UPDATE food SET fname=#{fname},cnumber=#{cnumber},price=#{price},fphoto=#{fphoto},finfo=#{finfo},fsell=#{fsell},cstock=#{cstock},fstatus=#{fstatus} WHERE fid=#{fid} ")
    public int updateFood(Food food);
    //查询全部菜品信息
    @Select("SELECT fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus FROM food")
    public List<Food> queryFood();
    //按照菜品id查询菜品信息
    @Select("SELECT fid,fname,cnumber,price,fphoto,finfo,fsell,cstock,fstatus FROM food WHERE fid=#{fid}")
    public Food queryFoodById(@Param("fid")Integer fid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品分页查询（带查询条件）
     */
    public List<Food> findFood(@Param("start") Integer start, @Param("size") Integer size, @Param("keyword") String keyword);
}
