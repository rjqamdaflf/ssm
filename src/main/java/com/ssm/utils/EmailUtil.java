package com.ssm.utils;

public class EmailUtil {

    public static boolean isEmail(String email) {
        if (email == null || email.equals(""))
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if (email.matches(regEx1))
            return true;
        return false;
    }
}
