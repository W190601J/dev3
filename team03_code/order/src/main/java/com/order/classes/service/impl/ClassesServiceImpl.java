package com.order.classes.service.impl;

import com.order.classes.mapper.ClassesMapper;
import com.order.classes.pojo.Cuisine;
import com.order.classes.service.ClassesService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
   @Autowired
   private ClassesMapper classesMapper;
    @Override
    public int addClasses(Cuisine cuisine) {
        return classesMapper.addClasses(cuisine);
    }

    @Override
    public int delClasses(Integer cid) {
        return classesMapper.delClasses(cid);
    }

    @Override
    public int updateClasses(Cuisine cuisine) {
        return classesMapper.updateClasses(cuisine);
    }

    @Override
    public List<Cuisine> queryCuisine() {
        return classesMapper.queryCuisine();
    }

    @Override
    public Cuisine queryCuisineById(Integer cid) {
        return classesMapper.queryCuisineById(cid);
    }

    @Override
    public List<Cuisine> findClasses(Integer page, Integer pageSize, String keyword) {
        //计算查询范围
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return classesMapper.findClasses(start, size,keyword);
    }
}
