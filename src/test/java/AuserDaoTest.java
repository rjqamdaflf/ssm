import com.ssm.dao.base.AuserDao;
import com.ssm.entity.base.Auser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuserDaoTest extends SpringTestBase {

    @Autowired
    AuserDao auserDao;

    @Test
    public void count() {
        System.out.println(auserDao.count());

    }


    @Test
    public void update() {
        Auser user = auserDao.selectOne(4);

        user.setAname("乱码？ ");
        auserDao.update(user);

    }

    @Test
    public void insert() {
        Auser auser = new Auser();
        auser.setApwd("123456");
        auser.setAname("jeiyginelif");
        System.out.println(auserDao.insert(auser));
    }

    @Test
    public void selectAll() {
        System.out.println(auserDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(auserDao.delete(1));
    }
}
