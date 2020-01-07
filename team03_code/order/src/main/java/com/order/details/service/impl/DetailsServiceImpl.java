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
        return dao.findAll(oid);
    }

    @Override
    public int Sum(Integer fid) {
        return dao.Sum(fid);
    }

    @Override
    public int SumTotal(Integer month) {
        return dao.SumTotal(month);
    }
}
