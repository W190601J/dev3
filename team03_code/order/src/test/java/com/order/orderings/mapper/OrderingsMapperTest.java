package com.order.orderings.mapper;

import com.order.orderings.pojo.Ordering;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderingsMapperTest {
    @Autowired
    private OrderingsMapper dao;

    @Test
    void addOrdering() {

        Ordering ordering = new Ordering();
        ordering.setOid("201912312257000001");
        ordering.setUid(21);
        ordering.setBname("万城");
        ordering.setBphone("15570756066");
        ordering.setAddress("南湖路文运街16号");
        ordering.setAmount((float) 1024.80);
        int a = dao.addOrdering(ordering);

        if(a==1){
            Ordering ordering1 = dao.findone(ordering.getOid());
            if(ordering1!=null){
                System.out.println(ordering1.toString());
            }
        }
    }

    @Test
    void findAll(){
        List<Ordering> list = dao.findAll(21);
        for (Ordering order:
             list) {
            System.out.println(order.toString());
        }

    }

    @Test
    void cancle(){
        Ordering ordering = new Ordering();
        ordering.setOid("201912312257000001");
        Ordering ordering1 = dao.cancel(ordering);
        System.out.println(ordering1.toString());
    }
}