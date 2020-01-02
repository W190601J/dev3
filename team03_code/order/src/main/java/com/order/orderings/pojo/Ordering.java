package com.order.orderings.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.order.details.pojo.Detail;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
public class Ordering implements Serializable {
    private String oid;//订单ID
    private Integer uid;//买家ID
    private String bname;//买家姓名
    private String bphone;//买家电话
    private String address;//买家地址
    private Float amount;//订单总额
    private Integer pay;//订单支付状态： 0支付 1支付
    private Integer orderstatus;//订单状态：0为新订单，1为完结订单，2为取消订单
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;//订单创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//订单修改时间
    private List<Detail> detailList;

    public Ordering() {

    }

    public Ordering(String oid, Integer uid, String bname, String bphone, String address, Float amount, Integer pay, Integer orderstatus, Date createtime, Date updatetime, List<Detail> detailList) {
        this.oid = oid;
        this.uid = uid;
        this.bname = bname;
        this.bphone = bphone;
        this.address = address;
        this.amount = amount;
        this.pay = pay;
        this.orderstatus = orderstatus;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.detailList = detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBphone() {
        return bphone;
    }

    public void setBphone(String bphone) {
        this.bphone = bphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "oid='" + oid + '\'' +
                ", uid=" + uid +
                ", bname='" + bname + '\'' +
                ", bphone='" + bphone + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", pay=" + pay +
                ", orderstatus=" + orderstatus +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", detailList=" + detailList +
                '}';
    }
}
