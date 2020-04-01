import com.ssm.dao.admin.AdminDao;
import com.ssm.entity.base.Auser;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminDaoTest extends SpringTestBase {


    @Resource
    AdminDao adminDao;

    @Test
    public void findAllList() {
        String sa = "jfjjofie";
        System.out.println(adminDao.selectAll());
    }

    @Test
    public void insert() {
        Auser auser = new Auser();
        auser.setAname("揭贡进");
        auser.setApwd("123456");
        System.out.println(adminDao.insert(auser));
    }

}
