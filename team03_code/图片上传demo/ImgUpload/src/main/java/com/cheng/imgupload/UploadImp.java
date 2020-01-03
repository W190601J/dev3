package com.cheng.imgupload;

import org.springframework.beans.factory.annotation.Autowired;


public class UploadImp implements UploadMapper{

    @Autowired
    private UploadMapper dao;

    @Override
    public Upload query(Integer id) {
        return dao.query(id);
    }

    @Override
    public int save(Upload upload) {
        return dao.save(upload);
    }
}
