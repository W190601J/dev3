package com.order.chefs.mapper;

import com.order.chefs.pojo.Chef;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChefMapper {
    //添加厨师信息
    @Insert("INSERT INTO chef (cname,cinfo,cphoto) VALUES (#{cname},#{cinfo},#{cphoto})")
    public int addChef(Chef chef);

    //删除厨师信息
    @Delete("DELETE FROM chef where chid=#{chid}")
    public int delChef(@Param("chid")Integer chid);

    //修改厨师信息
    @Update("UPDATE chef SET cname=#{cname},cinfo=#{cinfo},cphoto=#{cphoto} WHERE chid=#{chid} ")
    public int updateChef(Chef chef);

    //查询全部厨师信息
    @Select("SELECT chid,cname,cinfo,cphoto FROM chef")
    public List<Chef> queryChef();
    //按照id查询厨师信息
    @Select("SELECT chid,cname,cinfo,cphoto FROM chef WHERE chid=#{chid}")
    public List<Chef> queryChefById(@Param("chid")Integer chid);
    /**
 * start：起始位置
 * size：查询条数
 * keyword：查询条件
 * 厨师分页查询（带查询条件）
 */
public List<Chef> findChef(@Param("start") Integer start, @Param("size") Integer size, @Param("keyword") String keyword);
}
