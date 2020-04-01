package com.ssm.exception;

import com.ssm.entity.base.Auser;
import com.ssm.entity.base.Buser;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", e);
        // 根据不同错误转向不同页面
        if(e instanceof AdminLoginNoException){
            //登录页面需要auser对象
            httpServletRequest.setAttribute("auser", new Auser());
            httpServletRequest.setAttribute("msg", "没有登录，请登录！");
            return new ModelAndView("redirect:/admin/login", model);
        } else if(e instanceof UserLoginNoException){
            httpServletRequest.setAttribute("buser", new Buser());
            httpServletRequest.setAttribute("msg", "没有登录，请登录！");
            return new ModelAndView("/before/login", model);
        }else{
            return new ModelAndView("/error/error", model);
        }
    }
}
