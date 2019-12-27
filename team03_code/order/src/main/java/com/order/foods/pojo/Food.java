package com.order.foods.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品
 */
public class Food implements Serializable {
    private  Integer fid;//菜品ID
    private  String fname;//菜品名
    private  Integer cnumber;//菜品编号
    private  Float price;//菜品价格
    private  String fphoto;//菜品图片
    private  String finfo;//菜品简介
    private  Integer fsell;//菜品销量 默认为：0
    private  Integer cstock;//菜品库存
    private  Integer fstatus;//菜品状态：0正常 1为下架
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fcreate;//菜品创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fupdate;//菜品修改时间
    private String beiyong1;//备用
   public Food(){

   }
    public Food(Integer fid, String fname, Integer cnumber, Float price, String fphoto, String finfo, Integer fsell, Integer cstock, Integer fstatus, Date fcreate, Date fupdate, String beiyong1) {
        this.fid = fid;
        this.fname = fname;
        this.cnumber = cnumber;
        this.price = price;
        this.fphoto = fphoto;
        this.finfo = finfo;
        this.fsell = fsell;
        this.cstock = cstock;
        this.fstatus = fstatus;
        this.fcreate = fcreate;
        this.fupdate = fupdate;
        this.beiyong1 = beiyong1;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getFphoto() {
        return fphoto;
    }

    public void setFphoto(String fphoto) {
        this.fphoto = fphoto;
    }

    public String getFinfo() {
        return finfo;
    }

    public void setFinfo(String finfo) {
        this.finfo = finfo;
    }

    public Integer getFsell() {
        return fsell;
    }

    public void setFsell(Integer fsell) {
        this.fsell = fsell;
    }

    public Integer getCstock() {
        return cstock;
    }

    public void setCstock(Integer cstock) {
        this.cstock = cstock;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public Date getFcreate() {
        return fcreate;
    }

    public void setFcreate(Date fcreate) {
        this.fcreate = fcreate;
    }

    public Date getFupdate() {
        return fupdate;
    }

    public void setFupdate(Date fupdate) {
        this.fupdate = fupdate;
    }

    public String getBeiyong1() {
        return beiyong1;
    }

    public void setBeiyong1(String beiyong1) {
        this.beiyong1 = beiyong1;
    }
}
