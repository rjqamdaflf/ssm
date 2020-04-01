package com.ssm.controller.admin;


import com.ssm.controller.ServiceController;
import com.ssm.entity.base.Auser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController extends ServiceController {


    @RequestMapping("/index")
    public String toLogin(Auser auser) {
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(Auser auser, Model model, HttpSession session) {

        if (auserService.login(auser)) {
            session.setAttribute("auser", auser);
            //添加商品与修改商品页面使用
            session.setAttribute("goodsType", goodsService.selectAllGoodType());
            return "admin/main";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "admin/login";
        }
    }

    @RequestMapping("/exit")
    public String exit(Auser auser, HttpSession session) {
        session.invalidate();
        return "admin/login";
    }

}
