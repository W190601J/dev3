package com.order.foods.service.impl;

import com.order.foods.mapper.FoodsMapper;
import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FoodsServiceImpl")
public class FoodsServiceImpl implements FoodsService {

    @Autowired
    private FoodsMapper foodsMapper;
    @Override
    public int addFood(Food food) {
        return foodsMapper.addFood(food);
    }

    @Override
    public int delFood(Integer fid) {
        return foodsMapper.delFood(fid);
    }

    @Override
    public int updateFood(Food food) {
        return foodsMapper.updateFood(food);
    }

    @Override
    public List<Food> queryFood(Integer cnumber,Integer page,Integer pageSize) {
        //计算查询范围
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return foodsMapper.queryFood(cnumber,start,size);
    }

    @Override
    public Food queryFoodById(Integer fid) {
        return foodsMapper.queryFoodById(fid);
    }

    @Override
    public List<Food> queryFoodByStatus() {
        return foodsMapper.queryFoodByStatus();
    }

    @Override
    public int addStock(Integer fid, Integer number) {
        return foodsMapper.addStock(fid, number);
    }

    @Override
    public int reduceStock(Integer fid, Integer number) {
        Food food = foodsMapper.queryFoodById(fid);
        if(food.getCstock()-number<0){
            throw new RuntimeException();
        }
        int a = foodsMapper.reduceStock(fid, number);
        return a;
    }

    @Override
    public int addsells(Integer fid, Integer number) {
        return foodsMapper.addsells(fid, number);
    }

    @Override
    public int sold(Integer fstatus, Integer fid) {
        return 0;
    }

    @Override
    public List<Food> findFood(Integer page, Integer pageSize,Integer cnumber) {
        //计算查询范围
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return foodsMapper.findFood(start,size,cnumber);
    }

    @Override
    public int querytt(Integer cnumber) {
        return foodsMapper.querytt(cnumber);
    }

    @Override
    public List<Food> queryFid() {
        return foodsMapper.queryFid();
    }
}
