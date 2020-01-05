package com.order.userses.mapper;

import com.order.userses.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UsersesMapper {
    //添加用户
    @Insert("INSERT INTO users(uname,upwd,uphone,rank)VALUES(uname=#{uname},upwd=#{upwd},uphone#{uphone},rank#{rank})")
    public int addUser(User user);
    //删除用户
    @Delete("DELETE FROM users where uid=#{uid}")
    public int delUser(@Param("uid")Integer uid);
    //修改用户
    @Update("UPDATE users SET uname=#{uname},upwd=#{upwd},uphone#{uphone},rank#{rank} WHERE uid=#{uid}  ")
    public  int updateUser(User user);
    //查询全部用户
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users")
    public List<User> queryUser();
    //按照uid查询用户
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users WHERE uid=#{uid}")
    public User queryUserById(@Param("uid")Integer uid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 用户分页查询（带查询条件）
     */
    public List<User> findUser(@Param("start") Integer start, @Param("size") Integer size, @Param("keyword") String keyword);


    //查询用户名是否存在
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users WHERE uname=#{uname}")
    public int queryUserByUname(@Param("uname")String uname);
    //验证登录
    @Select("SELECT uid,uname,upwd,uphone,ucreate,userupdate,rank FROM users WHERE uname=#{uname} AND upwd=#{upwd}")
    public int longin(@Param("uname")String uname,@Param("upwd")String upwd);
}
