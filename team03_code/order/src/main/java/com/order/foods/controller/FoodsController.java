package com.order.foods.controller;

import com.order.foods.pojo.Food;
import com.order.foods.service.impl.FoodsServiceImpl;
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
 * 菜品信息模块
 */
@RestController
@RequestMapping("/foods")
public class FoodsController {
    @Autowired
    private FoodsServiceImpl fs;

    //添加菜品
    @RequestMapping(value = "/food",method = RequestMethod.POST)
    public int add(HttpServletRequest request) throws IOException, ServletException {
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
        String fid = request.getParameter("fid");
        String cnumber = request.getParameter("cnumber");
        String fname = request.getParameter("fname");
        String price = request.getParameter("price");
        String finfo = request.getParameter("finfo");
        String cstock = request.getParameter("cstock");
        Food food=new Food();
        try {
            food.setCnumber(Integer.parseInt(cnumber));
            food.setCstock(Integer.parseInt(cstock));
            food.setFid(Integer.parseInt(fid));
            food.setFname(fname);
            food.setPrice(Float.parseFloat(price));
            food.setFinfo(finfo);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        food.setFphoto(filename);

        int a = fs.addFood(food);
        return a;
    }

    //删除菜品
    @RequestMapping(value = "/{fid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("fid")Integer fid){
        int i =fs.delFood(fid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改菜品信息
    @RequestMapping(value = "/food",method = RequestMethod.PUT)
    public int update(HttpServletRequest request) throws IOException, ServletException {
        /**** 修改 ****/
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
        String fid = request.getParameter("fid");
        String cnumber = request.getParameter("cnumber");
        String fname = request.getParameter("fname");
        String price = request.getParameter("price");
        String finfo = request.getParameter("finfo");
        String cstock = request.getParameter("cstock");
        String fstatus = request.getParameter("fstatus");
        Food food=new Food();
        try {
            food.setCnumber(Integer.parseInt(cnumber));
            food.setCstock(Integer.parseInt(cstock));
            food.setFid(Integer.parseInt(fid));
            food.setFname(fname);
            food.setPrice(Float.parseFloat(price));
            food.setFinfo(finfo);
            food.setFstatus(Integer.parseInt(fstatus));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        food.setFphoto(filename);

        int a = fs.updateFood(food);
        return a;
    }
    //查询所有
    @RequestMapping(value = "/queryFood/{cnumber}",method = RequestMethod.GET)
    public ResponseEntity<?> queryFood(@PathVariable("cnumber")Integer cnumber){
        List<Food> l1=fs.queryFood(cnumber);
        if(l1==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(l1,HttpStatus.OK);
    }
    //带条件分页查询
//    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
//    public ResponseEntity<List<Food>> find(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword){
//        List<Food> foodList = fs.findFood(page,pageSize,keyword);
//        if (foodList.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Food>>(foodList, HttpStatus.OK);
//    }
    //显示图片
    @GetMapping("/img/{mid}")
    public void img(@PathVariable("mid") Integer mid, OutputStream out) throws IOException {
        Food f1=fs.queryFoodById(mid);
        String img=f1.getFphoto();
        String url = "g:/x/img/"+img;
        File file=new File(url);
        InputStream input=new FileInputStream(file);
        //用于显示一张图片
        FileCopyUtils.copy(input,out);
    }
    //根据id查
    @GetMapping("/food/{fid}")
    public ResponseEntity<Food> queryById(@PathVariable("fid") Integer fid){
        Food food=fs.queryFoodById(fid);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }
}
