import com.ssm.dao.base.GoodsDao;
import com.ssm.entity.base.Goods;
import com.ssm.entity.GoodsAndType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsDaoTest extends SpringTestBase {

    @Autowired
    GoodsDao goodsDao;


    @Test
    public void testselectGoodsAndType() {

        GoodsAndType goodsAndType = goodsDao.selectGoodsAndType(200);
        System.out.println(goodsAndType.getGname());
        System.out.println(goodsAndType);
    }

    @Test
    public void count() {


        System.out.println(goodsDao.count());
    }

    @Test
    public void update() {
        Goods goods = goodsDao.selectOne(9);
        goods.setGpicture("fjeijqwiojfwfqfw");
        System.out.println(goodsDao.update(goods));
    }

    @Test
    public void insert() {
        Goods goods = new Goods();
        for (int i = 0; i < 50; i++) {
            goods.setGname("湛江鸡");
            goods.setGoprice(157.11 + i);
            goods.setGpicture("mfiejwioqjf" + i);
            goods.setGrprice(4547.11 + i);
            goods.setGstore(18 + i);
            goods.setGoodstype_id(1);
            System.out.println(goodsDao.insert(goods));
        }
    }


    @Test
    public void select() {
        System.out.println(goodsDao.selectOne(164));
    }

    @Test
    public void selectAll() {
        System.out.println(goodsDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(goodsDao.delete(13));
    }
}
