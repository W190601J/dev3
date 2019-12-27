package com.order.userses.controller;

import com.order.userses.pojo.User;
import com.order.userses.service.impl.UsersesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class UsersesController {
    @Autowired
    private UsersesServiceImpl usersesService;
    public ResponseEntity<Integer> query(User user){
        User u1=usersesService.query(user);
        if(u1!=null){
            return new ResponseEntity<>(1, HttpStatus.OK);
        }
        return new ResponseEntity<>(0,HttpStatus.UNAUTHORIZED);
    }
}
