import com.ssm.dao.admin.AdminGoodsDao;
import com.ssm.entity.base.Goods;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

public class AdminGoodsDaoTest extends SpringTestBase {
    @Resource
    AdminGoodsDao adminGoodsDao;

    @Test
    public void testAdminGoodsrDao() {
        Goods good = new Goods();
        good.setGname("北京烤鸭");
        good.setGoodstype_id(1);
        good.setGoprice(15.88);
        good.setGrprice(6544.0);
        good.setGpicture("jeweling");
        good.setGstore(15);
        int i = adminGoodsDao.insert(good);
        System.out.println(i);
    }


    @Test
    public void findAllList() {
        System.out.println(adminGoodsDao.selectAll());
    }

    @Test
    @Transactional
    @Rollback// 事务自动回滚，默认是true。可以不写
    public void testGet() {
        System.out.println(adminGoodsDao.selectOne(5));
    }

    @Test
    @Transactional
    @Rollback
    public void deleteList() {
        Integer[] id = {5, 6, 7, 8};
        System.out.println(adminGoodsDao.deleteListById(Arrays.asList(id)));
    }

    @Test
    public void update() {
        Goods good = adminGoodsDao.selectOne(9);
        System.out.println(good);
        good.setGname("香港烤鸭");
        System.out.println(good);
        int i = adminGoodsDao.update(good);
        System.out.println(i);
    }




    @Test
    public void testselectCartGoods() {
        Map<String, Goods> map = adminGoodsDao.selectCartGoods(9);
        System.out.println(map);
    }

}
