package com.ssm.controller.admin;

import com.ssm.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController {



    @RequestMapping("/orderInfo")
    public String orderInfo(Model model) {
        model.addAttribute("orderList",orderService.orderInfo());
        return "admin/orderManager";
    }

}
