package com.order.orderings.service.impl;

import com.order.details.mapper.DetailsMapper;
import com.order.details.pojo.Detail;
import com.order.foods.mapper.FoodsMapper;
import com.order.foods.pojo.Food;
import com.order.orderings.mapper.OrderingsMapper;
import com.order.orderings.pojo.Ordering;
import com.order.orderings.service.OrderingsService;
import com.order.utils.OrderingIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OrderingsServiceImpl")
public class OrderingsServiceImpl implements OrderingsService {

    @Autowired
    private OrderingsMapper dao;

    @Autowired
    private FoodsMapper fdao;

    @Autowired
    private DetailsMapper detailDao;


    @Override
    public int addOrdering(Ordering ordering) {
        return dao.addOrdering(ordering);
    }

    //创建订单。
    @Override
    @Transactional
    public Ordering create(Ordering ordering) {

        String OID = OrderingIdGenerate.generate();
        //1、查询商品信息，包括其单价
        Float amountPrice = new Float(0);
        List<Detail> list = ordering.getDetailList();
        for (Detail detail : list) {
            Food food = fdao.queryFoodById(detail.getFid());
            if (food == null) {
                throw new RuntimeException();
            }

            //扣库存
            fdao.reduceStock(food.getFid(),detail.getQuantity());

            amountPrice += food.getPrice() * detail.getQuantity();
            //插入详情表
            detail.setOid(OID);
            detail.setDname(food.getFname());
            detail.setDprice(food.getPrice());
            detail.setDphoto(food.getFphoto());
            detailDao.detailsAdd(detail);
        }

            //插入主订单表
            Ordering ordering1 = new Ordering();
            ordering1.setOid(OID);
            ordering.setAmount(amountPrice);
            dao.addOrdering(ordering1);

            return ordering;
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
    public Ordering findone(String oid) {
        return dao.findone(oid);
    }

    @Override
    public List<Ordering> findAll(Integer uid) {
        return dao.findAll(uid);
    }
}
