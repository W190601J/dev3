package com.order.chefs.controller;

import com.order.chefs.pojo.Chef;
import com.order.chefs.service.impl.ChefSerciveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 厨师信息模块
 */
@RestController()
@RequestMapping("/chefs")
public class ChefController {
    @Autowired
    private ChefSerciveImpl ci;

    //添加厨师
    @RequestMapping(value = "/chef",method = RequestMethod.POST)
    public ResponseEntity<?> addChef(@PathVariable Chef chef){
        int i=ci.addChef(chef);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }
    //删除厨师
    @RequestMapping(value = "/{cid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("chid")Integer chid){
        int i =ci.delChef(chid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改厨师信息
    @RequestMapping(value = "/chef",method = RequestMethod.PUT)
    public ResponseEntity<?> updateChef(@PathVariable Chef chef){
        int i=ci.updateChef(chef);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //带条件分页查询
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
     public ResponseEntity<List<Chef>> find(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize,@PathVariable(name="keyword",required = false)String keyword){
        List<Chef> chefList = ci.findChef(page,pageSize,keyword);
        if (chefList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chefList, HttpStatus.OK);
    }
}
