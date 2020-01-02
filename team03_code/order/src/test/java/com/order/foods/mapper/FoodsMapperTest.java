package com.order.foods.mapper;

import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class FoodsMapperTest {

    @Autowired
    private FoodsMapper dao;

    @Autowired
    private FoodsService foodService;

    @Test
    void addFood() {

    }

    @Test
    void delFood() {
    }

    @Test
    void updateFood() {
    }

    @Test
    void queryFood() {
        List<Food> list = dao.queryFood();
        for (Food food:
                list) {
            System.out.println("食物名称："+food.getFname());
        }
    }

    @Test
    void queryFoodById() {
        Food food = dao.queryFoodById(2);
        System.out.println("============================");
        System.out.println(food.toString());
    }

    @Test
    void queryFoodByStatus() {
        List<Food> list = dao.queryFoodByStatus();
        for (Food food:
             list) {
            System.out.println("食物名称："+food.getFname());
        }
    }

    @Test
    void addStock() {
        dao.addStock(2,3);
        Food food = dao.queryFoodById(2);
        System.out.println(food.toString());
    }

    @Test
    void reduceStock() {
        int a = foodService.reduceStock(5,4);
        if(a==1){
            Food food = dao.queryFoodById(5);
            System.out.println(food.toString());
        }
    }

    @Test
    void sold() {
        dao.sold(0,2);
        Food food = dao.queryFoodById(2);
        System.out.println(food.toString());
    }
}