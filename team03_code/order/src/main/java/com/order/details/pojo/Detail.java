package com.order.details.pojo;

/**
 * 订单类
 */
public class Detail {
    private Integer did;//订单详情ID
    private Integer fid;//菜品ID
    private Integer oid;//订单总表ID
    private String dname;//当前菜品名
    private Float dprice;//菜品当前价格
    private String dphoto;//菜品图片
    private Integer quantity;//订购菜品数量
    private String beiyong;//备用

    public Detail(){

    }

    public Detail(Integer did, Integer fid, Integer oid, String dname, Float dprice, String dphoto, Integer quantity, String beiyong) {
        this.did = did;
        this.fid = fid;
        this.oid = oid;
        this.dname = dname;
        this.dprice = dprice;
        this.dphoto = dphoto;
        this.quantity = quantity;
        this.beiyong = beiyong;
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

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
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

    public String getBeiyong() {
        return beiyong;
    }

    public void setBeiyong(String beiyong) {
        this.beiyong = beiyong;
    }
}
