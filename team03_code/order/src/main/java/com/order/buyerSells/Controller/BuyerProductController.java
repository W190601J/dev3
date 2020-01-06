package com.order.buyerSells.Controller;

import com.order.classes.pojo.Cuisine;
import com.order.classes.service.ClassesService;
import com.order.foods.pojo.Food;
import com.order.foods.service.FoodsService;
import com.order.buyerSells.pojoVo.ClassVO;
import com.order.buyerSells.pojoVo.FoodsVO;
import com.order.buyerSells.pojoVo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 前端商品的展示，数据返回。
 */

@RestController
@RequestMapping("/buyerlist/show")
public class BuyerProductController {


    @Autowired
    FoodsService foodsService;

    @Autowired
    ClassesService classesService;


    /**
     * 已上架商品数据数据接口返回前端
     * @return
     */
    @GetMapping("/list")
    public ResultVO pshow() {

        //查找所有已经上架菜品
        List<Food> foodList = foodsService.queryFoodByStatus();
        System.out.println("上架菜品:"+foodList);
        List<Cuisine> listAll = classesService.queryCuisine();

        //set集合方法
        Set<Cuisine> setlist = new HashSet<>();

        //已有菜品的类目集合
        List<Cuisine> classList = new ArrayList<>();

        //用set集合来去除重复元素。
        for (Food food:foodList) {
            for (Cuisine cuisine:listAll) {
                if(food.getCnumber()==cuisine.getCnumber()){
                    setlist.add(cuisine);
                }
            }
        }

        for (Cuisine cuisine:setlist) {
            classList.add(cuisine);
        }
        System.out.println("上架菜品所属类目:"+classList);

        //数据封装
        List<ClassVO> classVOList = new ArrayList<>();
        for (Cuisine cuisine:classList) {
            ClassVO cvo = new ClassVO();
            cvo.setCname(cuisine.getCname());
            cvo.setCnumber(cuisine.getCnumber());

            List<FoodsVO> fvoList = new ArrayList<>();
            for (Food food:foodList) {
                if(food.getCnumber()==cuisine.getCnumber()){
                    FoodsVO fvo = new FoodsVO();
                    //拷贝属性，当属性名和类型相同时。
                    BeanUtils.copyProperties(food,fvo);
                    fvoList.add(fvo);
                }
            }
            cvo.setFoodsVOList(fvoList);
            classVOList.add(cvo);
        }

        ResultVO fc = new ResultVO<>();
        fc.setCode(0);
        fc.setMsg("成功");
        fc.setData(classVOList);
        return fc;
    }


}
