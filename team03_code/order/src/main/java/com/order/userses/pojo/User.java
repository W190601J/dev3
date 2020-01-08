package com.order.userses.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 */
public class User implements Serializable {
    private Integer uid;//用户ID
    private String uname;//用户名
    private String upwd;//用户密码
    private String uphone;//用户电话
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ucreate;//用户创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  //timezone属性正常情况下 不需要加
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userupdate;//用户更新时间

    public  User(){

    }

    public User(Integer uid, String uname, String upwd, String uphone, Date ucreate, Date userupdate) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.uphone = uphone;
        this.ucreate = ucreate;
        this.userupdate = userupdate;

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Date getUcreate() {
        return ucreate;
    }

    public void setUcreate(Date ucreate) {
        this.ucreate = ucreate;
    }

    public Date getUserupdate() {
        return userupdate;
    }

    public void setUserupdate(Date userupdate) {
        this.userupdate = userupdate;
    }
}
