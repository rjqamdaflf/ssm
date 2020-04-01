package com.ssm.controller.before;

import com.ssm.utils.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseBeforeController {

    @RequestMapping("/orderSubmit")
    public String orderSubmit(Model model, HttpSession session, Double amount) {
        model.addAttribute("ordersn", orderService.orderSubmit(MyUtil.getUserId(session)));
        return "before/orderdone";
    }


    /**
     * 支付订单
     */
    @RequestMapping("/pay")
    public String pay(Integer ordersn) {
        return orderService.pay(ordersn);
    }

}
