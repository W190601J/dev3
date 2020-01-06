package com.order.classes.controller;


import com.order.classes.pojo.Cuisine;
import com.order.classes.service.impl.ClassesServiceImpl;

import com.order.utils.UploadDirMgr;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 菜品类型模块
 */
@RestController
@RequestMapping("/class")
public class ClassesController {
    @Autowired
    private ClassesServiceImpl cls;


    //添加菜品
    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    public int upload(HttpServletRequest request) throws IOException, ServletException {
        /**** 新增 ****/
        // 先上传文件、再保存信息至数据库

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
        String cname = request.getParameter("cname");
        String cnumber = request.getParameter("cnumber");
        String cid = request.getParameter("cid");
        Cuisine cu=new Cuisine();
        try {
            cu.setCname(cname);
            cu.setCid(Integer.parseInt(cid));
            cu.setCnumber(Integer.parseInt(cnumber));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        cu.setBeiyong1(filename);

        int a = cls.addClasses(cu);
        return a;
    }

    //根据菜品类型ID删除菜品类
    @RequestMapping(value = "/{cid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delClasses(@PathVariable("cid")Integer cid){
        int i=cls.delClasses(cid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
    }

    //修改菜品类
    @RequestMapping(value = "/cuisine",method = RequestMethod.PUT)
    public int update(HttpServletRequest request) throws IOException, ServletException {
        /**** 新增 ****/
        // 先上传文件、再保存信息至数据库

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
        String cname = request.getParameter("cname");
        String cnumber = request.getParameter("cnumber");
        String cid = request.getParameter("cid");
        Cuisine cu=new Cuisine();
        try {
            cu.setCname(cname);
            cu.setCid(Integer.parseInt(cid));
            cu.setCnumber(Integer.parseInt(cnumber));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        cu.setBeiyong1(filename);

        int a = cls.updateClasses(cu);
        return a;
    }

    //分页查询菜品类
    @RequestMapping(value = {"{page}/{pageSize}/{keyword}","chef/{page}/{pageSize}"},method = RequestMethod.GET)
    public  ResponseEntity<List<Cuisine>> findClasses(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword) {
        List<Cuisine> lc=cls.findClasses(page,pageSize,keyword);
        if (lc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }
    @RequestMapping(value = {"/queryCuisine"},method = RequestMethod.GET)
    public  ResponseEntity<List<Cuisine>> queryCuis() {
        List<Cuisine> lc=cls.queryCuisine();
        if (lc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }
    //显示图片
    @GetMapping("/img/{mid}")
    public void img(@PathVariable("mid") Integer mid, OutputStream out) throws IOException {
        Cuisine c1=cls.queryCuisineById(mid);
        String img=c1.getBeiyong1();
        String url = "g:/x/img/"+img;
        File file=new File(url);
        InputStream input=new FileInputStream(file);
        //用于显示一张图片
        FileCopyUtils.copy(input,out);
    }
    //根据id查
    @GetMapping("/queryById/{cid}")
    public ResponseEntity<Cuisine> queryById(@PathVariable("cid") Integer cid){
        Cuisine cu=cls.queryCuisineById(cid);
        if(cu==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cu,HttpStatus.OK);

    }

}
