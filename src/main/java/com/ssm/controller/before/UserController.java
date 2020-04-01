package com.ssm.controller.before;

import com.ssm.controller.ServiceController;
import com.ssm.entity.base.Buser;
import com.ssm.utils.EmailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends ServiceController {

    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    @ResponseBody
    public boolean getCode(String email) {
        if (!EmailUtil.isEmail(email))
            return false;
        else {
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("code", buserService.sendCode(email));
            return true;
        }
    }

    @RequestMapping("/register")
    public String register(Buser buser, Model model, String code) {
        System.out.println(buser);
        if (!code.equals(httpSession.getAttribute("code").toString()) || !buser.getBemail().equals(httpSession.getAttribute("email"))) {
            model.addAttribute("msg", "验证码错误！");
            model.addAttribute("buser", buser);
            return "before/register";
        }
        if (buserService.getUserByEmail(buser.getBemail()).size() > 0) {
            model.addAttribute("msg", "该账户已经注册，请登录！");
            return "before/login";
        }
        if (buserService.register(buser) > 0)
            return "before/login";
        else {
            model.addAttribute("msg", "注册失败！");
            model.addAttribute("buser", buser);
            return "before/register";
        }
    }

    @RequestMapping("/login")
    public String login(Buser buser, Model model, HttpSession session, String code) {
        System.out.println(buser + "叫我穷附件 就覅哦我就");
        if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("msg", "验证码错误！");
            return "before/login";
        }
        List<Buser> list = buserService.login(buser);

        if (list.size() > 0) {
            session.setAttribute("bruser", list.get(0));
            return "forward:/before";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "before/login";
        }
    }

    @RequestMapping("/exit")
    public String exit() {
        httpSession.invalidate();
        return "forward:/before";
    }
}
