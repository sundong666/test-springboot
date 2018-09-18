package com.asiainfo.springboot.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器一般用于权限认证，日志信息等
 */
public class LoginInterceptor implements HandlerInterceptor {
    // 在执行目标方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userName = request.getSession().getAttribute("userName");
        if (StringUtils.isEmpty(userName)) {
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
