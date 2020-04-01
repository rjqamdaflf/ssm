import com.ssm.dao.base.CartDao;
import com.ssm.entity.base.Cart;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDaoTest extends SpringTestBase {

    @Autowired
    CartDao cartDao;

    @Test
    public void selectCart() {
        System.out.println(cartDao.selectCart(3));
    }

    @Test
    public void selectCartGoodsByGoodsId() {

        List<Cart> carts = cartDao.selectCartGoodsByGoodsId(9);
        System.out.println(carts);
    }

    @Test
    public void update() {
        Cart cart = cartDao.selectOne(2);
        System.out.println(cart);
        cart.setShoppingnum(110);
        System.out.println(cartDao.update(cart));

    }

    @Test
    public void insert() {
        Cart cart = new Cart();
        cart.setShoppingnum(111);
        cart.setBuser_id(3);
        cart.setGoods_id(9);
        System.out.println(cartDao.insert(cart));
    }

    @Test
    public void selectAll() {
        System.out.println(cartDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(cartDao.delete(3,225));
    }
}
