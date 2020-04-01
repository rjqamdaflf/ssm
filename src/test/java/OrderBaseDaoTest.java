import com.ssm.dao.base.OrderDao;
import com.ssm.entity.base.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBaseDaoTest extends SpringTestBase {

    @Autowired
    OrderDao orderDao;

    @Test
    public void myOrder() {
        System.out.println(orderDao.myOrder(3));
    }

    @Test
    public void update() {
        Order order = orderDao.selectOne(9);
        order.setAmount((double) 6666);
        System.out.println(orderDao.update(order));
    }

    @Test
    public void insert() {
        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            order.setBusertable_id(3);
            order.setAmount(157.2 + i);
            order.setStatus(1);
            order.setOrderdate(sdf.format(new Date()));
            System.out.println(orderDao.insert(order));
        }
    }

    @Test
    public void selectAll() {
        System.out.println(orderDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(orderDao.delete(3));
    }
}
