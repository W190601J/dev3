package com.order.userses.service.impl;

import com.order.userses.mapper.UsersesMapper;
import com.order.userses.pojo.User;
import com.order.userses.service.UsersesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersesServiceImpl implements UsersesService {
    @Autowired
    private UsersesMapper usersesMapper;
    @Override
    public User query(User user) {
        return usersesMapper.query(user);
    }
}
