package com.ssm.entity.base;

import lombok.Data;

@Data
public class Notice {
    private Integer id; //公告ID（PK自增）
    private String ntitle; //标题
    private String ncontent; //内容
    private String ntime;//YYYY-MM-DD HH:MM:SS 公告时间
}
