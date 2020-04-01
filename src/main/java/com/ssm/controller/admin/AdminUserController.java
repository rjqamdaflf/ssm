package com.ssm.controller.admin;

import com.ssm.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        model.addAttribute("date", buserService.userInfo());
        return "admin/userManager";
    }

    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(Integer id, Model model) {
        buserService.deleteuserManager(id);
        return "forward:/adminUser/userInfo";
    }

}
