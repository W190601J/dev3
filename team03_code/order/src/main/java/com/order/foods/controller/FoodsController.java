package com.order.foods.controller;

import com.order.foods.pojo.Food;
import com.order.foods.service.impl.FoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜品信息模块
 */
@RestController
@RequestMapping("/foods")
public class FoodsController {
    @Autowired
    private FoodsServiceImpl fs;

    //添加菜品
    @RequestMapping(value = "/food",method = RequestMethod.POST)
    public ResponseEntity<?> addChef(@RequestBody Food food){
        int i=fs.addFood(food);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }

    //删除菜品
    @RequestMapping(value = "/{fid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("fid")Integer fid){
        int i =fs.delFood(fid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改菜品信息
    @RequestMapping(value = "/food",method = RequestMethod.PUT)
    public ResponseEntity<?> updateChef(@RequestBody Food food){
        int i=fs.updateFood(food);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //查询所有
    @RequestMapping(value = "/queryFood",method = RequestMethod.GET)
    public ResponseEntity<?> queryFood(){
        List<Food> l1=fs.queryFood();
        if(l1==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(l1,HttpStatus.OK);
    }
    //带条件分页查询
//    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
//    public ResponseEntity<List<Food>> find(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword){
//        List<Food> foodList = fs.findFood(page,pageSize,keyword);
//        if (foodList.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Food>>(foodList, HttpStatus.OK);
//    }
}
