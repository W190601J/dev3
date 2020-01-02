package com.order.orderings.service.impl;

import com.order.details.mapper.DetailsMapper;
import com.order.details.pojo.Detail;
import com.order.foods.mapper.FoodsMapper;
import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
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

    @Autowired
    private FoodsService foodService;


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
            System.out.println(food.toString());
            if (food == null) {
                throw new RuntimeException();
            }
            //扣库存
            foodService.reduceStock(food.getFid(), detail.getQuantity());

            amountPrice += food.getPrice() * detail.getQuantity();
            //插入详情表
            detail.setOid(OID);
            detail.setDname(food.getFname());
            detail.setDprice(food.getPrice());
            detail.setDphoto(food.getFphoto());
            detailDao.detailsAdd(detail);
        }

        //插入主订单表
//        Ordering ordering1 = new Ordering();
        ordering.setOid(OID);
        ordering.setAmount(amountPrice);
        System.out.println();
        dao.addOrdering(ordering);

        return ordering;
    }

    //取消订单
    @Override
    public Ordering cancel(Ordering ordering) {
        return dao.cancel(ordering);
    }

    //支付订单
    @Override
    public int pay(Ordering ordering) {
        return dao.pay(ordering);
    }

    //根据订单编号查询订单的所有数据信息，包括订单详情信息
    @Override
    public Ordering findone(String oid) {
        Ordering ordering = dao.findone(oid);
        if(ordering==null){
            throw new RuntimeException();
        }
        List<Detail> list = detailDao.findAll(oid);
        if(list.isEmpty()){
            throw new RuntimeException();
        }
        ordering.setDetailList(list);
        return ordering;
    }

    @Override
    public List<Ordering> findAll(Integer uid) {
        List<Ordering> orderingList = dao.findAll(uid);
        if(orderingList.isEmpty()){
            throw new RuntimeException();
        }
        for (Ordering ordering:orderingList) {
            List<Detail> list = detailDao.findAll(ordering.getOid());
            ordering.setDetailList(list);
        }
        return orderingList;
    }
}
