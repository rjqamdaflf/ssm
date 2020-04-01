package com.ssm.service.base.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.GoodsAndType;
import com.ssm.entity.GoodsType;
import com.ssm.entity.base.Goods;
import com.ssm.service.BaseService;
import com.ssm.service.base.GoodsService;
import com.ssm.utils.MyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl extends BaseService implements GoodsService {


    /**
     * 查询一个商品
     *
     * @return
     */
    public GoodsAndType selectAGoods(Integer id) {
        return goodsDao.selectGoodsAndType(id);
    }

    //查询所有商品类型
    public List<GoodsType> selectAllGoodType() {
        return goodsTypeDao.selectAll();
    }


    public JSONObject deleteAGoods(Integer id) {
        //商品有关联
        JSONObject json = new JSONObject();
        if (cartDao.selectCartGoodsByGoodsId(id).size() > 0 ||
                focusDao.selectFocusGoodsByGoodsId(id).size() > 0 ||
                orderDetailDao.selectOrderdetailGoodsByGoodsId(id).size() > 0) {
            json.put("msg", "商品有关联，不允许删除！");
        }
        goodsDao.delete(id);
        json.put("msg", "成功删除商品！");
        return json;
    }


    public Object selectGoodsById(Integer id) {
        return goodsDao.selectOne(id);
    }

    public List<Goods> search(String mykey) {
        return goodsDao.search(mykey);
    }

    public List<Map<String, Object>> getLastedGoods(Goods goods) {
        return goodsDao.getLastedGoods(goods);
    }

    /**
     * 查询商品
     *
     * @return
     */
    public JSONObject selectGoods(Integer pageCur) {
        JSONObject json = new JSONObject();
        int temp = goodsDao.count();
        json.put("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 10);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 10 > temp) {
            pageCur = pageCur - 1;
        }
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur - 1) * 10);//起始位置
        map.put("perPageSize", 10);//每页10个
        List<Goods> allGoods = goodsDao.selectAllGoodsByPage(map);
        json.put("allGoods", allGoods);
        json.put("totalPage", totalPage);
        json.put("pageCur", pageCur);
        return json;
    }


    //    添加商品或修改商品
    public boolean addOrUpdateGoods(Goods goods, String path, String act) {
        if (goods.getLogoImage() != null) {
            String newFileName = "";
            String fileName = goods.getLogoImage().getOriginalFilename();
            //选择了文件
            if (fileName.length() > 0) {
                //实现文件上传
                String fileType = fileName.substring(fileName.lastIndexOf('.'));
                //防止文件名重名
                newFileName = MyUtil.getStringID() + fileType;
                System.out.println("newFileName" + newFileName);
                goods.setGpicture(newFileName);
                File targetFile = new File(path, newFileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //上传
                try {
                    goods.getLogoImage().transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (act.equals("add")) {
            if (goodsDao.insert(goods) > 0)
                return true;
        } else if (act.equals("update")) {
            if (goodsDao.update(goods) > 0)
                return true;
        }
        return false;
    }

    public JSONObject getAllType() {
        JSONObject json = new JSONObject();
        json.put("allTypes", goodsTypeDao.selectAll());
        return json;
    }

    public int addType(GoodsType type) {
        return goodsTypeDao.insert(type);
    }

    public int deleteType(Integer id) {
        return goodsTypeDao.delete(id);
    }

}
