package com.order.details.service;

import com.order.details.pojo.Detail;

import java.util.List;

public interface DetailsService {

    public int detailsAdd(Detail detail);

    public List<Detail> findAll(String oid);
}
