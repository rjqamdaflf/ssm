package com.ssm.service.base;

import com.ssm.entity.base.Notice;

import java.util.List;

public interface NoticeService {
    public Notice getANotice(Integer id);

    public List<Notice> getAllNotice();

    public int deleteNotice(Integer id);

    public int addNotice(Notice notice);
}
