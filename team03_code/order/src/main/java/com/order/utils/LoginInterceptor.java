package com.order.utils;

import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    private String tokenHeader="Authorization";
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    //后端控制器执行前被调用，如果返回true,表示放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("调用了preHandle方法.....");

//        HttpSession session = request.getSession();
//        String uid = (String) session.getAttribute("uid");
//        log.info("uid:" + uid);
        String token=request.getHeader(tokenHeader);
        try {
            Claims c=jwtTokenUtil.parseJWT(token);
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
        return true;
    }

    //该方法会在控制器调用之后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle...被调用");
    }

    //该方法会在整个请求处理完之后被调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion....被调用");
    }
}
