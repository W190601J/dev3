package com.order.orderings.controller;

import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordering")
@Slf4j
public class OrderingsController {

    @Autowired
    private OrderingsService service;

    //创建订单ok
    @PostMapping("/order/create")
    public Ordering create(@RequestBody Ordering ordering){
        return service.create(ordering);
    }

    //完结订单（必需有oid属性）ok
    @PutMapping("/finish")
    public int finish(@RequestBody Ordering ordering){
        return service.finish(ordering);
    }


    //取消订单（必需有uid与oid两个属性）ok
    @PutMapping("/cancel")
    public int cancel(@RequestBody Ordering ordering){
        return service.cancel(ordering);
    }

    //支付订单（必需有uid与oid两个属性）ok
    @PutMapping("/order")
    public int pay(@RequestBody Ordering ordering){
        return service.pay(ordering);
    }

    //查询单个订单ok
    @GetMapping("/order/{oid}")
    public Ordering findone(@PathVariable("oid") String oid){
        return service.findone(oid);
    }

    //查询此用户下的所有的订单ok
    @GetMapping("/order/{uid}/")
    public List<Ordering> findAll(@PathVariable("uid") Integer uid){
        return service.findAll(uid);
    }

    //查询所有订单ok
    @GetMapping("/order/query")
    public List<Ordering> queryAll(){
        return service.queryAll();
    }

}
