package com.order.userses.service;

import com.order.userses.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersesService {

    //验证用户信息
    public User check(User user);
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

    //查询用户名是否存在
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users WHERE uname=#{uname}")
    public int queryUserByUname(String uname);
    //验证登录
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users WHERE uname=#{uname} AND upwd=#{upwd}")
    public int login(String uname,String upwd);

}
