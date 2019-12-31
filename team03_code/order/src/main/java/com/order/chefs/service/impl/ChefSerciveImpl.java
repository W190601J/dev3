package com.order.chefs.service.impl;

import com.order.chefs.mapper.ChefMapper;
import com.order.chefs.pojo.Chef;
import com.order.chefs.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChefSerciveImpl implements ChefService {
    @Autowired
    private ChefMapper chefMapper;

    @Override
    public int addChef(Chef chef) {
        return chefMapper.addChef(chef);
    }

    @Override
    public int delChef(Integer cid) {
        return chefMapper.delChef(cid);
    }

    @Override
    public int updateChef(Chef chef) {
        return chefMapper.updateChef(chef);
    }

    @Override
    public Chef queryChefById(Integer cid) {
        return chefMapper.queryChefById(cid);
    }

    @Override
    public List<Chef> findChef(Integer page, Integer pageSize, String keyword) {
        //计算查询范围

        int start = (page - 1) * pageSize;
        int size = pageSize;

        return chefMapper.findChef(start, size,keyword);
    }
}
