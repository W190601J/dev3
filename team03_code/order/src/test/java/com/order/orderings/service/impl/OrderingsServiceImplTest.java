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
        ordering.setUid(22);
        ordering.setBname("王先生");
        ordering.setBphone("15570758899");
        ordering.setAddress("公园路17号");
        List<Detail> detailList = new ArrayList<Detail>();
        Detail detail1 = new Detail();
        detail1.setQuantity(4);
        detail1.setFid(5);
        detailList.add(detail1);
        ordering.setDetailList(detailList);
        System.out.println(ordering.toString());
        service.create(ordering);
    }

    @Test
    void findone(){
        Ordering ordering = service.findone("14268720200101102257");
        System.out.println(ordering);

    }

    @Test
    void findAll(){
        List<Ordering> orderingList = service.findAll(21);
        System.out.println(orderingList);
    }

    @Test
    void cancel(){
        Ordering ordering = new Ordering();
        ordering.setOid("61320820200101094954");
        service.cancel(ordering);

    }

    @Test
    void finish(){
        Ordering ordering = new Ordering();
        ordering.setOid("84988520200106095021");
        service.finish(ordering);

    }

    @Test
    void pay(){
        Ordering ordering = new Ordering();
        ordering.setOid("201912312257000001");
        service.pay(ordering);

    }


}