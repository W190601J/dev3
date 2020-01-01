package com.order.details.controller;

import com.order.details.pojo.Detail;
import com.order.details.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailsController {

    @Autowired
    private DetailsService service;

    @PostMapping("/detail")
    public int detailsAdd(@RequestBody Detail detail){
        return service.detailsAdd(detail);
    }

    @GetMapping("/detail/{oid}")
    public List<Detail> findAll(@PathVariable("oid") String oid){
        return service.findAll(oid);
    }

}
