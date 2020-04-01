package com.ssm.utils;


import com.ssm.entity.base.Buser;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
    /**
     * 获得时间字符串
     */
    public static String getFormatDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    /**
     * 获得时间字符串
     */
    public static String getStringID() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 获得用户ID
     */
    public static Integer getUserId(HttpSession session) {
        Buser ruser = (Buser) session.getAttribute("bruser");
        return ruser.getId();
    }
}
