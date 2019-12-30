package com.order.userses.service.impl;

import com.order.userses.mapper.UsersesMapper;
import com.order.userses.pojo.User;
import com.order.userses.service.UsersesService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UsersesServiceImpl implements UsersesService {
    @Autowired
    private UsersesMapper usersesMapper;
    @Override
    public int addUser(User user) {
        return usersesMapper.addUser(user);
    }

    @Override
    public int delUser(Integer uid) {
        return usersesMapper.delUser(uid);
    }

    @Override
    public int updateUser(User user) {
        return usersesMapper.updateUser(user);
    }

    @Override
    public List<User> queryUser() {
        return usersesMapper.queryUser();
    }

    @Override
    public User queryUserById(Integer uid) {
        return usersesMapper.queryUserById(uid);
    }

    @Override
    public List<User> findUser(Integer page, Integer pageSize, String keyword) {
        //计算查询范围
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return usersesMapper.findUser(start, size, keyword);
    }
}
