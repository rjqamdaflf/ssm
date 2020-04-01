package com.ssm.service.base.impl;

import com.ssm.entity.base.Notice;
import com.ssm.service.BaseService;
import com.ssm.service.base.NoticeService;
import com.ssm.utils.MyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl extends BaseService implements NoticeService {

    public Notice getANotice(Integer id) {
        return noticeDao.selectOne(id);
    }

    public List<Notice> getAllNotice() {
        return noticeDao.selectAll();
    }

    public int deleteNotice(Integer id) {
        return noticeDao.delete(id);
    }

    public int addNotice(Notice notice) {
        notice.setNtime(MyUtil.getFormatDate());
        return noticeDao.insert(notice);
    }
}
