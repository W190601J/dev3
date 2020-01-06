package com.order.userses.controller;

import com.order.userses.pojo.User;
import com.order.userses.service.impl.UsersesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersesController {
    @Autowired
    private UsersesServiceImpl usersesService;

    //验证用户
    @PostMapping("/check")
    public ResponseEntity<?> check(@RequestBody User user){
        User a = usersesService.check(user);
        if(a==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
    }


//添加用户
@RequestMapping(value = "/user",method = RequestMethod.POST)
public ResponseEntity<?> addChef(@PathVariable User user){
    int i=usersesService.addUser(user);
    if (i!=1){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
}
    //删除用户
    @RequestMapping(value = "/{uid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("uid")Integer uid){
        int i =usersesService.delUser(uid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改用户信息
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseEntity<?> updateChef(@PathVariable User user){
        int i=usersesService.updateUser(user);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //带条件分页查询
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
    public ResponseEntity<List<User>> find(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword){
        List<User> chefList = usersesService.findUser(page,pageSize,keyword);
        if (chefList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chefList, HttpStatus.OK);
    }

}
