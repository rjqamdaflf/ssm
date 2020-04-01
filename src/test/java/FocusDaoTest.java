import com.ssm.dao.base.FocusDao;
import com.ssm.entity.base.Focus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FocusDaoTest extends SpringTestBase {

    @Autowired
    FocusDao focusDao;

    @Test
    public void myFocus(){
        System.out.println(focusDao.myFocus(3));
    }

    @Test
    public void update() {
        Focus focus = focusDao.selectOne(2);
        System.out.println(focus);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        focus.setFocustime(sdf.format(new Date()));
        System.out.println(focusDao.update(focus));

    }

    @Test
    public void insert() {
        Focus focus = new Focus();
        focus.setGoods_id(10);
        focus.setBuser_id(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        focus.setFocustime(sdf.format(new Date()));
        System.out.println(focusDao.insert(focus));
    }

    @Test
    public void selectAll() {
        System.out.println(focusDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(focusDao.delete(1));
    }
}
