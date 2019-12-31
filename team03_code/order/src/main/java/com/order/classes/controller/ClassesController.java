package com.order.classes.controller;

import com.order.classes.pojo.Cuisine;
import com.order.classes.service.impl.ClassesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜品类型模块
 */
@RestController
@RequestMapping("/class")
public class ClassesController {
    @Autowired
    private ClassesServiceImpl cls;

    //添加菜品
    @RequestMapping(value = "/cuisine",method = RequestMethod.POST)
    public ResponseEntity<?> addClasses(@RequestBody Cuisine cuisine){
        int i=cls.addClasses(cuisine);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }

    //根据菜品类型ID删除菜品类
    @RequestMapping(value = "/{cid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delClasses(@PathVariable("cid")Integer cid){
        int i=cls.delClasses(cid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }

    //修改菜品类
    @RequestMapping(value = "/cuisine",method = RequestMethod.PUT)
    public  ResponseEntity<?> updateClasses(@RequestBody Cuisine cuisine){
        int i =cls.updateClasses(cuisine);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }

    //分页查询菜品类
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/chef/{page}/{pageSize}"},method = RequestMethod.GET)
    public  ResponseEntity<List<Cuisine>> findClasses(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword) {
        List<Cuisine> lc=cls.findClasses(page,pageSize,keyword);
        if (lc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }
}
