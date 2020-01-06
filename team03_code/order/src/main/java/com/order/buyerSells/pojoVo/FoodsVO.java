package com.order.buyerSells.pojoVo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 商品详情
 *
 * Created by X
 */
@Data
public class FoodsVO {

    @JsonProperty("id")
    private Integer fid;

    @JsonProperty("name")
    private String fname;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("info")
    private String finfo;

    @JsonProperty("photo")
    private String fphoto;


}
