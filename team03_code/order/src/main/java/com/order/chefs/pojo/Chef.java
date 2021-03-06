package com.order.chefs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 厨师类
 */
public class Chef implements Serializable {
    private Integer chid;//厨师ID
    private String cname;//厨师姓名
    private String cinfo;//厨师简介
    private String cphoto;//厨师照片
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ccreate;//厨师新增时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cupdate;//厨师修改时间

    public Chef() {

    }

    public Chef(Integer chid, String cname, String cinfo, String cphoto, Date ccreate, Date cupdate) {
        this.chid = chid;
        this.cname = cname;
        this.cinfo = cinfo;
        this.cphoto = cphoto;
        this.ccreate = ccreate;
        this.cupdate = cupdate;
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getCphoto() {
        return cphoto;
    }

    public void setCphoto(String cphoto) {
        this.cphoto = cphoto;
    }

    public Date getCcreate() {
        return ccreate;
    }

    public void setCcreate(Date ccreate) {
        this.ccreate = ccreate;
    }

    public Date getCupdate() {
        return cupdate;
    }

    public void setCupdate(Date cupdate) {
        this.cupdate = cupdate;
    }
}
