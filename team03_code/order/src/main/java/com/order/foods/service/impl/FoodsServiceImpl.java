package com.order.foods.service.impl;

import com.order.foods.mapper.FoodsMapper;
import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Food> queryFood() {
        return foodsMapper.queryFood();
    }

    @Override
    public Food queryFoodById(Integer fid) {
        return foodsMapper.queryFoodById(fid);
    }

    @Override
    public List<Food> findFood(Integer page, Integer pageSize, String keyword) {
        //计算查询范围
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return foodsMapper.findFood(start, size,keyword);
    }
}
