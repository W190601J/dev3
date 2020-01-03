package com.cheng.imgupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cheng.imgupload")
public class ImguploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImguploadApplication.class, args);
    }

}
