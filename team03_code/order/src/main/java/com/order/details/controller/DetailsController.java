package com.order.details.controller;

import com.order.details.pojo.Detail;
import com.order.details.service.DetailsService;
import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetailsController {

    @Autowired
    private DetailsService service;
    @Autowired
    private FoodsService foodsService;

    @PostMapping("/detail")
    public int detailsAdd(@RequestBody Detail detail){
        return service.detailsAdd(detail);
    }

    @GetMapping("/detail/{oid}")
    public List<Detail> findAll(@PathVariable("oid") String oid){
        return service.findAll(oid);
    }

    @GetMapping("/sum")
    public List<Integer> Sum(){
        System.out.println(2222);
        List<Food> lf=foodsService.queryFid();
         List<Integer> li=new ArrayList<>();
        for (Food food:lf
             ) {
            if(service.Sum(food.getFid())==null){

                li.add(0);
            }else{
                li.add(service.Sum(food.getFid()));
            }

        }
        return li;
    }
    @GetMapping("/sums")
    public List<String> Sums(){
        System.out.println(1111);
        List<Food> lf=foodsService.queryFid();
        List<String> ls=new ArrayList<>();
        for (Food food:lf
        ) {
            System.out.println(food.getFname());
            ls.add(food.getFname());
        }
        return ls;
    }
}
