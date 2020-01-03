package com.cheng.imgupload;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UploadMapper {

    @Select("select id,mname,mage,mphoto from upload where id=#{id}")
    public Upload query(Integer id);

    @Insert("insert into upload(mname,mage,mphoto) values (#{mname},#{mage},#{mphoto})")
    public int save(Upload upload);

}
