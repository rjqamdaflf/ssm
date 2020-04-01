package com.ssm.service.base.impl;

import com.ssm.entity.FocusAndGoods;
import com.ssm.service.BaseService;
import com.ssm.service.base.FocusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FocusServiceImpl extends BaseService implements FocusService {
    public List<Map<String, Object>> getFocusOrder() {
        return focusDao.getFocusOrder();
    }

    public List<FocusAndGoods> myFocus(Integer userId) {
        return focusDao.myFocus(userId);
    }
}
