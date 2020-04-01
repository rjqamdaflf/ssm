import com.ssm.dao.base.BuserDao;
import com.ssm.entity.base.Buser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BuserDaoTest extends SpringTestBase {

    @Autowired
    BuserDao auserDao;

    @Test
    public void getUserByEmail() {
        List<Buser> buser = auserDao.getUserByEmail("jeiyginelddddddif@gjifjei");
        System.out.println(buser);
    }

    @Test
    public void login() {
        Buser buser = new Buser();
        buser.setBemail("horseflyfly@gmail.com");
        buser.setBpwd("123456");
        System.out.println(auserDao.login(buser));
    }


    @Test
    public void update() {
        Buser user = auserDao.selectOne(1);

        user.setBemail("揭英勒地");
        auserDao.update(user);

    }

    @Test
    public void insert() {
        Buser auser = new Buser();
        auser.setBpwd("123456");
        auser.setBemail("jeiyginelif@gjifjei");
        System.out.println(auserDao.insert(auser));
    }

    @Test
    public void selectAll() {
        System.out.println(auserDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(auserDao.delete(2));
    }
}
