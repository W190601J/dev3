package com.order.chefs.controller;

import com.order.chefs.pojo.Chef;
import com.order.chefs.service.ChefService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 厨师信息模块
 */
@RestController()
@RequestMapping("/chefs")
public class ChefController {

    private static final Logger log = LoggerFactory.getLogger(ChefController.class);

    @Autowired
    private ChefService ci;

    //添加厨师
    @RequestMapping(value = "/chef",method = RequestMethod.POST)
    public ResponseEntity<?> addChef(@RequestBody Chef chef){
        int i=ci.addChef(chef);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }
    //删除厨师
    @RequestMapping(value = "/{chid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("chid")Integer chid){
        System.out.println("chid:"+chid);
        int i =ci.delChef(chid);
        System.out.println("i:"+i);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改厨师信息
    @RequestMapping(value = "/chef",method = RequestMethod.PUT)
    public ResponseEntity<?> updateChef(@RequestBody Chef chef){
        log.info("cname:{}",chef.getCname());
        int i=ci.updateChef(chef);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //根据ID查询厨师的所有信息
    @RequestMapping(value = "/chef/{chid}",method = RequestMethod.GET)
    public ResponseEntity<?> updateChef(@PathVariable Integer chid){
        Chef i=ci.queryChefById(chid);
        if (i==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    //带条件分页查询
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
     public ResponseEntity<List<Chef>> find(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize,@PathVariable(name="keyword",required = false)String keyword){
        log.info("page:{}",page);
        log.info("pageSize:{}",pageSize);
        log.info("keyword:{}",keyword);
        List<Chef> chefList = ci.findChef(page,pageSize,keyword);
        if (chefList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chefList, HttpStatus.OK);
    }
}
