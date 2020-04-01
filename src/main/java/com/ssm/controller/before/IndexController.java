package com.ssm.controller.before;

import com.ssm.controller.ServiceController;
import com.ssm.entity.base.Buser;
import com.ssm.entity.base.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController extends ServiceController {


    @RequestMapping("/")
    public String redicert() {
        return "redirect:/before";
    }

    /**
     * 首页
     */
    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType", goodsService.selectAllGoodType());
        model.addAttribute("salelist", orderService.getSaleOrder());
        model.addAttribute("focuslist", focusService.getFocusOrder());
        model.addAttribute("noticelist", noticeService.getAllNotice());
        if (goods.getId() == null)
            goods.setId(0);
        model.addAttribute("lastedlist", goodsService.getLastedGoods(goods));
        return "before/index";
    }

    /**
     * 转到注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model) {
        model.addAttribute("buser", new Buser());
        return "before/register";
    }

    /**
     * 转到登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        model.addAttribute("lbuser", new Buser());
        return "before/login";
    }

    /**
     * 转到商品详情页
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model, Integer id) {
        System.out.println("RequestMapping：/goodsDetail 接收到id:" + id);
        model.addAttribute("goods", goodsService.selectGoodsById(id));
        return "before/goodsdetail";
    }

    /**
     * 转到公告页面
     */
    @RequestMapping("/selectANotice")
    public String selectANotice(Model model, Integer id) {
        model.addAttribute("notice", noticeService.getANotice(id));
        return "admin/noticeDetail";
    }

    /**
     * 首页搜索
     */
    @RequestMapping("/search")
    public String search(Model model, String mykey) {
        model.addAttribute("searchlist", goodsService.search(mykey));
        return "before/searchResult";
    }

}
