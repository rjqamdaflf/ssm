package com.ssm.entity.base;

import lombok.Data;

/**
 * 与数据表ausertable对应
 */

@Data
public class Auser {
    private int id;
    private String aname;   //用户名
    private String apwd;  //密码


}