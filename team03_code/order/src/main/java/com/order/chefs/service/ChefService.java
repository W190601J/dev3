package com.order.chefs.service;

import com.order.chefs.pojo.Chef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChefService  {
    //添加厨师信息
    public int addChef(Chef chef);
    //删除厨师信息
    public int delChef(Integer chid);
    //修改厨师信息
    public int updateChef(Chef chef);

    //按照id查询厨师信息
    public Chef queryChefById(@Param("chid")Integer chid);
    //分页带条件查询
    public List<Chef> findChef(Integer page, Integer pageSize);
    public int querytt();
}
