package com.order.orderings.service.impl;

import com.order.orderings.mapper.OrderingsMapper;
import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderingsServiceImpl implements OrderingsService {

    private OrderingsMapper dao;
    @Override
    public Ordering create(Ordering ordering) {
        return dao.create(ordering);
    }

    @Override
    public Ordering cancel(Ordering ordering) {
        return dao.cancel(ordering);
    }

    @Override
    public int pay(Ordering ordering) {
        return dao.pay(ordering);
    }

    @Override
    public Ordering findone(Integer oid) {
        return dao.findone(oid);
    }

    @Override
    public List<Ordering> findAll(Integer uid) {
        return dao.findAll(uid);
    }
}
