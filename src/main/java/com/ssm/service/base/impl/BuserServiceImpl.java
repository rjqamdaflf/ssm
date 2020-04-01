package com.ssm.service.base.impl;

import com.ssm.entity.base.Buser;
import com.ssm.service.BaseService;
import com.ssm.service.base.BuserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BuserServiceImpl extends BaseService implements BuserService {

    @Resource
    private RabbitTemplate rabbitTemplate;


    public List<Buser> userInfo() {
        return buserDao.selectAll();
    }

    //删除一个用户
    public int deleteuserManager(Integer id) {
        //用户有关联
        if (cartDao.selectCart(id).size() > 0 ||
                focusDao.myFocus(id).size() > 0 ||
                orderDao.myOrder(id).size() > 0) {
            return 0;
        }
        return buserDao.delete(id);
    }

    public String sendCode(String email) {
        String random = RandomStringUtils.randomNumeric(6);
        Map<String, String> map = new HashMap<String, String>();
        map.put("address", email);
        map.put("subject", "验证码");
        map.put("body", "您的验证码为：" + random);
        System.out.println(map);
        rabbitTemplate.convertAndSend("email", "sendCode", map);
        return random;
    }


    public List<Buser> getUserByEmail(String email) {
        return buserDao.getUserByEmail(email);
    }

    public int register(Buser buser) {
        return buserDao.insert(buser);

    }

    public List<Buser> login(Buser buser) {
        return buserDao.login(buser);

    }
}
