package com.order.orderings.controller;

import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordering")
public class OrderingsController {
    @Autowired
    private OrderingsService service;

    @PostMapping("/order")
    public Ordering create(@RequestBody Ordering ordering){
        return service.create(ordering);
    }

    @PostMapping("/cancel")
    public int cancel(@RequestBody Ordering ordering){
        return service.cancel(ordering);
    }

    @PutMapping("/order")
    public int pay(@RequestBody Ordering ordering){
        return service.pay(ordering);
    }

    @GetMapping("/order/{oid}")
    public Ordering findone(@PathVariable("oid") String oid){
        return service.findone(oid);
    }

    @GetMapping("/order/{uid}/")
    public List<Ordering> findAll(@PathVariable("uid") Integer uid){
        return service.findAll(uid);
    }




}
