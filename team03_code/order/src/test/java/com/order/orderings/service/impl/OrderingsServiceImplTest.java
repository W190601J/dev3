package com.order.orderings.service.impl;

import com.order.details.pojo.Detail;
import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderingsServiceImplTest {

    @Autowired
    private OrderingsService service;

    @Test
    void create() {
        Ordering ordering = new Ordering();
        ordering.setUid(21);
        ordering.setBname("张大大");
        ordering.setBphone("15876576966");
        ordering.setAddress("南苑第七百八十六号胡同");
        List<Detail> detailList = new ArrayList<>();
        Detail detail1 = new Detail();
        detail1.setQuantity(3);
        detail1.setFid(2);
        Detail detail2 = new Detail();
        detail1.setQuantity(3);
        detail1.setFid(3);
        detailList.add(detail1);
//        detailList.add(detail2);
        ordering.setDetailList(detailList);

        service.create(ordering);






    }
}