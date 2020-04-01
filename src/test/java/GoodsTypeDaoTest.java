import com.ssm.dao.base.GoodsTypeDao;
import com.ssm.entity.GoodsType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsTypeDaoTest extends SpringTestBase {

    @Autowired
    GoodsTypeDao goodsTypeDao;

    @Test
    public void update() {
        GoodsType goodsType = goodsTypeDao.selectOne(9);
        goodsType.setTypename("衣服");
        System.out.println(goodsTypeDao.update(goodsType));
    }

    @Test
    public void insert() {
        GoodsType goodsType = new GoodsType();
        for (int i = 0; i < 10; i++) {
            goodsType.setTypename("电器" + i);
            System.out.println(goodsTypeDao.insert(goodsType));
        }
    }

    @Test
    public void selectAll() {
        System.out.println(goodsTypeDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(goodsTypeDao.delete(13));
    }
}
