package com.order.details.service.impl;

import com.order.details.mapper.DetailsMapper;
import com.order.details.pojo.Detail;
import com.order.details.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("DetailsServiceImpl")
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsMapper dao;
    @Override
    public int detailsAdd(Detail detail) {
        return dao.detailsAdd(detail);
    }

    @Override
    public List<Detail> findAll(String oid) {
        System.out.println(1);
        List<Detail> l1=dao.findAll(oid);
        return l1;
    }

    @Override
    public Integer Sum(Integer fid) {
        return dao.Sum(fid);
    }

}
