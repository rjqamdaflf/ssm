package com.ssm.controller.admin;


import com.ssm.controller.BaseController;
import com.ssm.entity.GoodsType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController {


    @RequestMapping("/getAllType")
    public String getAllType(Model model) {
        model.addAttribute("date", goodsService.getAllType());
        return "admin/allType";
    }

    @RequestMapping("/toAddType")
    public String toAddType(Model model) {
        model.addAttribute("type", new GoodsType());
        return "admin/addType";
    }

    @RequestMapping("/addType")
    public String addType(GoodsType type, Model model) {
        System.out.println(type);
        if (goodsService.addType(type) > 0)
            return "forward:/adminType/getAllType";
        else {
            model.addAttribute("msg", "添加失败，请重新添加!");
            model.addAttribute("oldType", type);
            return "forward:/adminType/toAddType";
        }
    }

    @RequestMapping("/deleteType")
    public String deleteType(int id) {
        System.out.println(id);
        goodsService.deleteType(id);
        return "forward:/adminType/getAllType";
    }


}
