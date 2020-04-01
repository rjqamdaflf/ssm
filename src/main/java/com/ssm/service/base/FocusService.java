package com.ssm.service.base;

import com.ssm.entity.FocusAndGoods;

import java.util.List;
import java.util.Map;

public interface FocusService {

    public List<Map<String, Object>> getFocusOrder();

    public List<FocusAndGoods> myFocus(Integer userId);

}
