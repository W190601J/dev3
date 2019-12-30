package com.order.userses.mapper;

import com.order.userses.pojo.User;
<<<<<<< HEAD
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

=======
import org.apache.ibatis.annotations.Select;

public interface UsersesMapper {
    @Select("select uname,upwd from sells.users where uname=#{user.uname} and upwd=#{user.upwd} and rank=0")
    public User query(User user);
>>>>>>> 7a4dbc5e6ecf0630f5250f962eb1cd2e0987926c
}
