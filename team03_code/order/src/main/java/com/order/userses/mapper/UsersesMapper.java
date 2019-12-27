package com.order.userses.mapper;

import com.order.userses.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UsersesMapper {
    @Select("select uname,upwd from sells.users where uname=#{user.uname} and upwd=#{user.upwd} and rank=0")
    public User query(User user);
}
