package com.ssm.controller.admin;

import com.ssm.controller.BaseController;
import com.ssm.entity.base.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController {


    @RequestMapping("/toAddNotice")
    public String toAddNotice(Model model) {
        model.addAttribute("notice", new Notice());
        return "admin/addNotice";
    }

    @RequestMapping("/addNotice")
    public String addNotice(Notice notice) {
        noticeService.addNotice(notice);
        return "forward:/adminNotice/selectAllNotice";
    }


    @RequestMapping("/selectAllNotice")
    public String selectAllNotice(Model model) {
        model.addAttribute("allNotices", noticeService.getAllNotice());
        return "admin/allNotice";
    }


    @RequestMapping("/selectANotice")
    public String selectANotice(Model model, Integer id) {
        model.addAttribute("notice", noticeService.getANotice(id));
        return "admin/noticeDetail";
    }

    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer id) {
        noticeService.deleteNotice(id);
        return "forward:/adminNotice/selectAllNotice";
    }


}
