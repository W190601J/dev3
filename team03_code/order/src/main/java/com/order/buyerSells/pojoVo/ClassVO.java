package com.order.buyerSells.pojoVo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 * 
 * Created by X
 */
@Data
public class ClassVO {

    @JsonProperty("name")
    private String cname;

    @JsonProperty("type")
    private Integer cnumber;

    @JsonProperty("foods")
    private List<FoodsVO> FoodsVOList;


}
