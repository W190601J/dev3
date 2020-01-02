package com.order.details.pojo;

import com.order.orderings.pojo.Ordering;

/**
 * 订单详情类
 */
public class Detail {
    private Integer did;//订单详情ID
    private Integer fid;//菜品ID
    private String oid;//引用订单表
    private String dname;//当前菜品名
    private Float dprice;//菜品当前价格
    private String dphoto;//菜品图片
    private Integer quantity;//订购菜品数量


    public Detail(){

    }

    public Detail(Integer did, Integer fid, String oid, String dname, Float dprice, String dphoto, Integer quantity) {
        this.did = did;
        this.fid = fid;
        this.oid = oid;
        this.dname = dname;
        this.dprice = dprice;
        this.dphoto = dphoto;
        this.quantity = quantity;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Float getDprice() {
        return dprice;
    }

    public void setDprice(Float dprice) {
        this.dprice = dprice;
    }

    public String getDphoto() {
        return dphoto;
    }

    public void setDphoto(String dphoto) {
        this.dphoto = dphoto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "did=" + did +
                ", fid=" + fid +
                ", oid='" + oid + '\'' +
                ", dname='" + dname + '\'' +
                ", dprice=" + dprice +
                ", dphoto='" + dphoto + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
