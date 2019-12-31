package com.order.details.mapper;

import com.order.details.pojo.Detail;

import java.util.List;

public interface DetailsMapper {

    public int detailsAdd(Detail detail);

    public List<Detail> findAll(Integer oid);


}
