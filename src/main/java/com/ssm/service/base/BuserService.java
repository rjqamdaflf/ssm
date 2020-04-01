package com.ssm.service.base;

import com.ssm.entity.base.Buser;

import java.util.List;

public interface BuserService {

    public List<Buser> getUserByEmail(String email);

    public int register(Buser buser);

    public List<Buser> login(Buser buser);

    public List<Buser> userInfo();

    public int deleteuserManager(Integer id);

    String sendCode(String email);
}
