package com.cheng.imgupload;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@Controller
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private UploadMapper dao;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public int upload(HttpServletRequest request) throws IOException, ServletException {
        /**** 新增 ****/
        // 先上传文件、再保存信息至数据库
        logger.info("jjjjjj");

        Part p = request.getPart("mphoto");
        // 获得上传的文件名,是全文件名
        String submittedFileName = p.getSubmittedFileName();
        System.out.println("submittedFileName:"+submittedFileName);
        // 获得文件扩展名
        String extName = StringUtils.substringAfter(submittedFileName, ".");
        System.out.println("extName"+extName);
        // 保存至服务器的文件名
        String filename = UUID.randomUUID().toString() + "." + extName;
        System.out.println("filename:"+filename);

        File target = UploadDirMgr.getFile(filename);
        System.out.println("111111111111111111111111111");

        // 上传文件
        try (InputStream in = p.getInputStream(); OutputStream out = new FileOutputStream(target);

        ) {
            IOUtils.copyLarge(in, out);
        }
        System.out.println("上传完成！");
        String mname = request.getParameter("mname");
        String mage = request.getParameter("mage");
        Upload upload = new Upload();
        try {
            upload.setMage(Integer.parseInt(mage));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        upload.setMname(mname);
        upload.setMphoto(filename);
        int a = dao.save(upload);
        return a;
    }






    @GetMapping("/img/{mid}")
    public void img(@PathVariable("mid") Integer mid, OutputStream out) throws IOException {
        Upload upload = dao.query(mid);
        System.out.println(upload);
        String img = upload.getMphoto();
        String url = "d:/temp/"+img;
        File file=new File(url);
        InputStream input=new FileInputStream(file);
        //用于显示一张图片
        FileCopyUtils.copy(input,out);
    }
}
