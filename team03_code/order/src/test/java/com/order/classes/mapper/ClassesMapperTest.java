package com.order.classes.mapper;

import com.order.classes.pojo.Cuisine;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class ClassesMapperTest {
    @Autowired
    ClassesMapper dao;
    @Test
    @Transactional
    void updateClasses() {
        Cuisine cuisine = new Cuisine();
        cuisine.setCid(9);
        cuisine.setCname("徽徽菜");
        cuisine.setCnumber(80);
        int a = dao.updateClasses(cuisine);
        Assert.assertEquals(1,a);
    }

    @Test
    void queryCuisine(){
        List<Cuisine> list = dao.queryCuisine();
        Assert.assertEquals(8,list.size());
    }

    @Test
    void queryCuisineById(){
        Cuisine list = dao.queryCuisineById(9);
        Assert.assertEquals(new Integer(90),list.getCnumber());
    }
}