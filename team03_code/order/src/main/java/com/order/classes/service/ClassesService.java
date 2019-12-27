package com.order.classes.service;

import com.order.classes.pojo.Cuisine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ClassesService {
    //添加菜品类型
    public int addClasses(Cuisine cuisine);
    //删除菜品类型
    public  int delClasses(Integer cid);
    //修改菜品类型
    public  int updateClasses(Cuisine cuisine);
    //查询全部类型信息
    public List<Cuisine> queryCuisine();
    //按照CID查询类型信息
    public Cuisine queryCuisineById(Integer cid);
    /**
     * start：起始位置
     * size：查询条数
     * keyword：查询条件
     * 菜品类型分页查询（带查询条件）
     */
    public List<Cuisine> findClasses(Integer page, Integer pageSize, String keyword);
}
