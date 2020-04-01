package com.ssm.controller.admin;


import com.alibaba.fastjson.JSONObject;
import com.ssm.controller.BaseController;
import com.ssm.entity.base.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController extends BaseController {


    @RequestMapping("/selectGoods")
    public String selectGoods(Model model, Integer pageCur) {
        System.out.println(pageCur);
        model.addAttribute("date", goodsService.selectGoods(pageCur));
        System.out.println(model);
        return "admin/selectGoods";
    }

    /**
     * add页面初始化
     */
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model) {
        model.addAttribute("goods", new Goods());
        return "admin/addGoods";
    }


    /**
     * 添加与修改
     */
    @RequestMapping("/addOrUpdateGoods")
    public String addGoods(Goods goods, String act, Model model, HttpServletRequest request) {
        System.out.println(act);
        String path = request.getServletContext().getRealPath("logos");
        System.out.println(path);
        if (goods != null) {
            if (goodsService.addOrUpdateGoods(goods, path, act))
                return "forward:/adminGoods/selectGoods";
        }
        model.addAttribute("goods", goods);
        return "forward:/adminGoods/addOrUpdateGoods";
    }

    /**
     * 查询一个名片
     */
    @RequestMapping(value = "/selectAGoods", method = RequestMethod.GET)
    public String selectAGoods(Model model, Integer id) {
        model.addAttribute("goods", goodsService.selectAGoods(id));
        return "admin/goodsDetail";
    }

    @RequestMapping("/updateAgoods")
    public String updateAgoods(Model model, Integer id) {
        model.addAttribute("goods", goodsService.selectAGoods(id));
        return "admin/updateAgoods";
    }


    /**
     * 删除单个商品
     */
    @RequestMapping("/deleteAGoods")
    public String deleteAGoods(Integer id, Integer pageCur, Model model) {
        JSONObject json = goodsService.deleteAGoods(id);
        model.addAttribute("date", json);
        model.addAttribute("pageCur", pageCur);
        return "forward:/adminGoods/selectGoods";
    }


}
