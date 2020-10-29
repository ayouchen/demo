package com.jiyun.intercepter;

import com.jiyun.entity.Students;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().indexOf("login")>0 || request.getRequestURI().indexOf("register")>0){
            return true;
        }
        Students student = (Students) request.getSession().getAttribute("currentUser");
        if (student != null){
            //change1
            return  true;
        }
        response.sendRedirect("/studentb/login");
        return true;
    }
}
