package com.order.classes.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 菜品分类
 */
public class Cuisine {
    private Integer cid;//菜品类ID
    private Integer cnumber;//菜品类编号
    private String cname;//菜品类名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date classcreate;//菜品类创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date classupdate;//菜品类更新时间
    private String beiyong1;


    public Cuisine() {

    }

    public Cuisine(Integer cid, Integer cnumber, String cname, Date classcreate, Date classupdate) {
        this.cid = cid;
        this.cnumber = cnumber;
        this.cname = cname;
        this.classcreate = classcreate;
        this.classupdate = classupdate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getClasscreate() {
        return classcreate;
    }

    public void setClasscreate(Date classcreate) {
        this.classcreate = classcreate;
    }

    public Date getClassupdate() {
        return classupdate;
    }

    public void setClassupdate(Date classupdate) {
        this.classupdate = classupdate;
    }

    public String getBeiyong1() {
        return beiyong1;
    }

    public void setBeiyong1(String beiyong1) {
        this.beiyong1 = beiyong1;
    }
}
