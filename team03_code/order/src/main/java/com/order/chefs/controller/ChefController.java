package com.order.chefs.controller;

import com.order.chefs.pojo.Chef;
import com.order.chefs.service.ChefService;
import com.order.utils.UploadDirMgr;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 厨师信息模块
 */
@RestController()
@RequestMapping("/chefs")
public class ChefController {

    private static final Logger log = LoggerFactory.getLogger(ChefController.class);

    @Autowired
    private ChefService ci;

    //添加厨师
    @RequestMapping(value = "/chef",method = RequestMethod.POST)
    public int addChef(HttpServletRequest request) throws IOException, ServletException {
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
        String cinfo = request.getParameter("cinfo");
        Chef chef =new Chef();
        try {
            chef.setCinfo(cinfo);
            chef.setCname(cname);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        chef.setCphoto(filename);

        int a = ci.addChef(chef);
        return a;
    }
    //删除厨师
    @RequestMapping(value = "/{chid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("chid")Integer chid){
        System.out.println("chid:"+chid);
        int i =ci.delChef(chid);
        System.out.println("i:"+i);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改厨师信息
    @RequestMapping(value = "/chef",method = RequestMethod.PUT)
    public int updateChef(HttpServletRequest request) throws IOException, ServletException {
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
        String cinfo = request.getParameter("cinfo");
        String chid = request.getParameter("chid");
        Chef chef =new Chef();
        try {
            chef.setCinfo(cinfo);
            chef.setCname(cname);
            chef.setChid(Integer.parseInt(chid));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        chef.setCphoto(filename);

        int a = ci.updateChef(chef);
        return a;
    }
    //根据ID查询厨师的所有信息
    @RequestMapping(value = "/chef/{chid}",method = RequestMethod.GET)
    public ResponseEntity<?> queryById(@PathVariable Integer chid){
        Chef i=ci.queryChefById(chid);
        if (i==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    //带条件分页查询
    @RequestMapping(value = {"/{page}/{pageSize}"},method = RequestMethod.GET)
     public ResponseEntity<List<Chef>> find(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize){
        List<Chef> chefList = ci.findChef(page,pageSize);
        if (chefList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chefList, HttpStatus.OK);
    }
    //显示图片
    @GetMapping("/img/{chid}")
    public void img(@PathVariable("chid") Integer chid, OutputStream out) throws IOException {
        Chef c1=ci.queryChefById(chid);
        String img=c1.getCphoto();
        String url = "g:/x/img/"+img;
        File file=new File(url);
        InputStream input=new FileInputStream(file);
        //用于显示一张图片
        FileCopyUtils.copy(input,out);
    }
    //登录
    @GetMapping("/login/{uname}/{password}")
    public int login(@PathVariable("uname") String uname,@PathVariable("password") String password){
        if(uname=="admin"&&password=="123"){
            return 1;
        }
        return 0;
    }
    //查询总记录数
    @GetMapping("querytt")
    public int querytt(){
        int i=ci.querytt();
        return i;
    }
}
