package com.order.chefs.mapper;

import com.order.chefs.pojo.Chef;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class ChefMapperTest {

    @Autowired
    ChefMapper dao;

    @Test
    void queryChefById() {

       Chef chef = dao.queryChefById(1);
       Assert.assertNotEquals(java.util.Optional.of(1),chef.getChid());

    }
}