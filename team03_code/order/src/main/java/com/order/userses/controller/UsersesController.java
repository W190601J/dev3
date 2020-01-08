package com.order.userses.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.order.userses.pojo.User;
import com.order.userses.service.impl.UsersesServiceImpl;
import com.order.utils.JwtTokenUtil;
import com.order.utils.Note;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersesController {
    @Autowired
    private UsersesServiceImpl usersesService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private Note note;

    private String tokenHeader="Authorization";
//    //验证用户
//    @PostMapping("/check")
//    public ResponseEntity<?> check(@RequestBody User user){
//        User a = usersesService.check(user);
//        if(a==null){
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }else{
//            return new ResponseEntity<>(a, HttpStatus.OK);
//        }
//    }

//添加用户
//@RequestMapping(value = "/user",method = RequestMethod.POST)
//public ResponseEntity<?> addUser(@RequestBody User user){
//    int i=usersesService.addUser(user);
//    if (i!=1){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//    return new ResponseEntity<>(Integer.valueOf(i), HttpStatus.OK);
//}
    //删除用户
    @RequestMapping(value = "/{uid}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delChef(@PathVariable("uid")Integer uid){
        int i =usersesService.delUser(uid);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //修改用户信息
    @RequestMapping(value = "/user/",method = RequestMethod.PUT)
    public ResponseEntity<?> updateChef(@RequestBody User user){
        int i=usersesService.updateUser(user);
        if (i!=1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Integer.valueOf(i),HttpStatus.OK);
    }
    //带条件分页查询
    @RequestMapping(value = {"/{page}/{pageSize}/{keyword}","/{page}/{pageSize}"},method = RequestMethod.GET)
    public ResponseEntity<List<User>> find(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize, @PathVariable(name="keyword",required = false)String keyword){
        List<User> chefList = usersesService.findUser(page,pageSize,keyword);
        if (chefList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chefList, HttpStatus.OK);
    }
    //注册用户
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addChef(@RequestBody User user){
        //先进行用户搜索 确定用户名唯一性
        int i =usersesService.queryUserByUname(user.getUname());
        String s="用户名已存在";
        String p="注册成功";
        String q="注册失败";
        if (i==1){
            return s;
        }
        int o=usersesService.addUser(user);
        if (o!=1){
            return q;
        }
            return p;
}
    //获取验证码
    @RequestMapping(value = "/user/{phone}",method = RequestMethod.POST)
    public String yzms(@PathVariable("phone")String phone) throws ClientException {
        note.setNewcode();
        String code = Integer.toString(note.getNewcode());
        System.out.println("发送的验证码为："+code);
        //发短信
        SendSmsResponse response =note.sendSms(phone,code); // TODO 填写你需要测试的手机号码
         return  code;
    }
    //用户登录
    @RequestMapping(value = "/user/{uname}/{upwd}",method = RequestMethod.POST )
    public Object login(@PathVariable("uname")String uname,@PathVariable("upwd")String upwd){
//        //先进行用户搜索 确定用户名唯一性
//        int i =usersesService.queryUserByUname(uname);
//        String s="用户名已存在";
        String p="用户名密码不正确";
//        if (i==1){
//            return s;
//        }
        //验证账号密码正确
        User s =usersesService.login(uname,upwd);
        if (s==null){
            return null;
        }else {
            //生成token
            String token=jwtTokenUtil.createJwt(s.getUid(),s.getUname());
            return token;
        }
    }

    //返回用户对象
    @GetMapping("/check")
    public User login(HttpServletRequest request){
        String token=request.getHeader(tokenHeader);
        Claims c = jwtTokenUtil.parseJWT(token);
        Integer uid = (Integer) c.get("uid");
        String  uname=(String) c.get("uname");

        User se=usersesService.queryUserById(uid);

        return  se;
    }


}
