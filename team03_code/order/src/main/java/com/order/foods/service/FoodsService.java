package com.order.foods.service;

import com.order.chefs.pojo.Chef;
import com.order.foods.pojo.Food;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FoodsService {
    //添加菜品信息
    public int addFood(Food food);
    //删除菜品信息
    public int delFood(Integer fid);
    //修改菜品信息
    public int updateFood(Food food);
    //查询全部菜品信息
    public List<Food> queryFood(Integer cnumber);
    //按照菜品id查询菜品信息
    public Food queryFoodById(Integer fid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品分页查询（带查询条件）
     */
    //加库存,方法已测
    public int addStock(Integer fid,Integer number);

    //减库存,方法已测
    public int reduceStock(Integer fid,Integer number);

    //上下架菜品,方法已测
    public int sold(Integer fstatus,Integer fid);

    public List<Food> findFood(Integer page, Integer pageSize, String keyword);
}
