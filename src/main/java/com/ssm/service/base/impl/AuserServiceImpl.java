package com.ssm.service.base.impl;

import com.ssm.entity.base.Auser;
import com.ssm.service.BaseService;
import com.ssm.service.base.AuserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuserServiceImpl extends BaseService implements AuserService {

    //管理员登录
    public boolean login(Auser auser) {
        if (auserDao.login(auser) != null && auserDao.login(auser).size() > 0) {
            return true;
        }
        return false;
    }

}
