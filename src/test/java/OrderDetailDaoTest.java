import com.ssm.dao.base.OrderDetailDao;
import com.ssm.entity.base.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

public class OrderDetailDaoTest extends SpringTestBase {

    @Autowired
    OrderDetailDao orderDetailDao;


    @Test
    public void update() {
        OrderDetail orderDetail = orderDetailDao.selectOne(9);
        orderDetail.setShoppingnum(6666);
        System.out.println(orderDetailDao.update(orderDetail));
    }

    @Test
    public void insert() {
        OrderDetail orderDetail = new OrderDetail();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            orderDetail.setOrderbasetable_id(10);
            orderDetail.setGoodstable_id(9);
            orderDetail.setShoppingnum(10 + i);
            System.out.println(orderDetailDao.insert(orderDetail));
        }
    }

    @Test
    public void selectAll() {
        System.out.println(orderDetailDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(orderDetailDao.delete(13));
    }
}
