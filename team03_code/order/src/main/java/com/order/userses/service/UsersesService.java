package com.order.userses.service;

import com.order.userses.pojo.User;

import java.util.List;

public interface UsersesService {
    //添加用户
    public int addUser(User user);
    //删除用户
    public int delUser(Integer uid);
    //修改用户
    public  int updateUser(User user);
    //查询全部用户
    public List<User> queryUser();
    //按照uid查询用户
    public User queryUserById(Integer uid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 用户分页查询（带查询条件）
     */
    public List<User> findUser(Integer page, Integer pageSize,String keyword);

}
