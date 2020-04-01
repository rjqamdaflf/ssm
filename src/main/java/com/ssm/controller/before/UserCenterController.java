package com.ssm.controller.before;

import com.ssm.utils.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserCenterController extends BaseBeforeController {


    @RequestMapping("/userCenter")
    public String userCenter(HttpSession session, Model model) {
        Integer userId = MyUtil.getUserId(session);
        model.addAttribute("myOrder", orderService.myOrder(userId));
        model.addAttribute("myFocus", focusService.myFocus(userId));
        return "before/userCenter";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, Integer ordersn) {
        model.addAttribute("myOrderDetail", orderService.orderDetail(ordersn));
        return "before/userOrderDetail";
    }

}
