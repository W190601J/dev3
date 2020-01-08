package com.order.orderings.controller;

import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        System.out.println(11111);
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
    @GetMapping("/orderu/{uid}/")
    public List<Ordering> findAll(@PathVariable("uid") Integer uid){
        return service.findAll(uid);
    }
    //查询此用户下的所有的订单ok
    @GetMapping("/orderu2/{uid}")
    public List<Ordering> findAll2(@PathVariable("uid") Integer uid){
        System.out.println(service.findone2(uid));
        return service.findone2(uid);
    }

    //查询所有订单ok
    @GetMapping("/order/query")
    public List<Ordering> queryAll(){
        return service.queryAll();
    }

    //条件查询订单ok
    @RequestMapping(value = {"/order/{page}/{pageSize}/{keyword}","/order/{page}/{pageSize}/","/order/{page}/{pageSize}"}, method = RequestMethod.GET)
    public List<Ordering> queryAllBy(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize,@PathVariable(name="keyword",required = false)String keyword){
        return service.queryAllBy(page,pageSize,keyword);
    }
    /**
     * 得到总记录数
     * @return
     */
    @GetMapping({"/order/count/{keyword}","/order/count/","/order/count"})
    public int count(@PathVariable(required = false,value = "keyword") String keyword){
        return service.count(keyword);
    }
     //
    @GetMapping("/sumtotal")
    public List<String> SumTotal(){
        List<String> s= new ArrayList<>();
        for (int month=1;month<13;month++){
            String a=(String.valueOf(service.SumTotal(month)));
            if (a=="null"){
                a="0";
                System.out.println(a);
            }
            s.add(a);
        }
        return s;
    }
}

