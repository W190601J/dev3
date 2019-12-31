package com.order.foods.service;

import com.order.chefs.pojo.Chef;
import com.order.foods.pojo.Food;

import java.util.List;

public interface FoodsService {
    //添加菜品信息
    public int addFood(Food food);
    //删除菜品信息
    public int delFood(Integer fid);
    //修改菜品信息
    public int updateFood(Food food);
    //查询全部菜品信息
    public List<Food> queryFood();
    //按照菜品id查询菜品信息
    public Food queryFoodById(Integer fid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品分页查询（带查询条件）
     */
//    public List<Food> findFood(Integer page, Integer pageSize, String keyword);
}
