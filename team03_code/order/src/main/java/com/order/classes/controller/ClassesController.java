package com.order.classes.controller;

import com.order.classes.pojo.Cuisine;
import com.order.classes.service.impl.ClassesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜品类型模块
 */
@RestController
@RequestMapping("/class")
public class ClassesController {
    @Autowired
    private ClassesServiceImpl cls;

    @RequestMapping(value = "/cuisine",method = RequestMethod.POST)
    public ResponseEntity<?> addClasses(@PathVariable Cuisine cuisine){
        int i=cls.addClasses(cuisine);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }
    @RequestMapping(value = "/{cid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delClasses(@PathVariable("cid")Integer cid){
        int i=cls.delClasses(cid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }
    @RequestMapping(value = "/cuisine",method = RequestMethod.PUT)
    public  ResponseEntity<?> updateClasses(@PathVariable Cuisine cuisine){
        int i =cls.updateClasses(cuisine);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/chef/{page}/{pageSize}"},method = RequestMethod.GET)
    public  ResponseEntity<List<Cuisine>> findClasses(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword) {
        List<Cuisine> lc=cls.findClasses(page,pageSize,keyword);
        if (lc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }
}
