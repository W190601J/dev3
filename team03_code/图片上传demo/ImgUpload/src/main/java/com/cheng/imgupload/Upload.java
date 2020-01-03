package com.cheng.imgupload;

public class Upload {

    private Integer id;
    private String mname;
    private Integer mage;
    private String mphoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getMage() {
        return mage;
    }

    public void setMage(Integer mage) {
        this.mage = mage;
    }

    public String getMphoto() {
        return mphoto;
    }

    public void setMphoto(String mphoto) {
        this.mphoto = mphoto;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", mage='" + mage + '\'' +
                ", mphoto='" + mphoto + '\'' +
                '}';
    }
}
