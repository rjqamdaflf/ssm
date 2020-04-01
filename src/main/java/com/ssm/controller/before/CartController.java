package com.ssm.controller.before;

import com.ssm.entity.base.Cart;
import com.ssm.entity.base.Focus;
import com.ssm.utils.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController {

    /**
     * 关注商品
     */
    @RequestMapping("/focus")
    public String focus(Model model, Focus focus, HttpSession session) {
        focus.setBuser_id(MyUtil.getUserId(session));
        System.out.println(focus);
        //给下一个请求传入id
        //  model.addAttribute("id", focus.getGoods_id());
        model.addAttribute("date", cartService.focus(focus));
        //System.out.println("id       ++++"+model.getAttribute("id"));
        return "forward:/goodsDetail";
    }

    /**
     * 添加购物车
     */
    @RequestMapping("/putCart")
    public String putCart(Model model, Cart cart, HttpSession session, HttpServletRequest request) {
        System.out.println(cart);
        cart.setBuser_id(MyUtil.getUserId(session));
        int resule = cartService.putCart(cart);
        if (resule > 0)
            model.addAttribute("msg", "添加成功!");
        else if (resule == -1)
            model.addAttribute("msg", "库存不足!");
        else
            model.addAttribute("msg", "添加失败!");
        return "forward:/cart/selectCart";
    }

    /**
     * 查询购物车
     */
    @RequestMapping("/selectCart")
    public String selectCart(Model model, HttpSession session) {
        model.addAttribute("date", cartService.selectCart(MyUtil.getUserId(session)));
        return "before/cart";
    }

    /**
     * 删除购物车
     */
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Integer id, Model model, HttpSession session) {
        if (cartService.deleteAgoods(MyUtil.getUserId(session), id) > 0)
            model.addAttribute("msg", "删除成功!");
        else model.addAttribute("msg", "删除失败!");
        return "forward:/cart/selectCart";
    }

    /**
     * 清空购物车
     */
    @RequestMapping("/clear")
    public String clear(HttpSession session, Model model) {
        if (cartService.clear(MyUtil.getUserId(session)) > 0)
            model.addAttribute("msg", "清空成功!");
        else model.addAttribute("msg", "清空失败!");
        return "forward:/cart/selectCart";
    }

    /**
     * 去结算
     */
    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model, HttpSession session) {
        model.addAttribute("date", cartService.selectCart(MyUtil.getUserId(session)));
        return "before/orderconfirm";
    }

}
