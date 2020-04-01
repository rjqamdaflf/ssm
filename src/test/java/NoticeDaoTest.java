import com.ssm.dao.base.NoticeDao;
import com.ssm.entity.base.Notice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDaoTest extends SpringTestBase {

    @Autowired
    NoticeDao noticeDao;

    @Test
    public void update() {
        Notice notice = noticeDao.selectOne(9);
        notice.setNcontent("jfoejijwiqfjijqofe");
        System.out.println(noticeDao.update(notice));
    }

    @Test
    public void insert() {
        Notice notice = new Notice();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            notice.setNtitle("title" + i);
            notice.setNcontent("电器" + i);
            notice.setNtime(sdf.format(new Date()));
            System.out.println(noticeDao.insert(notice));
        }
    }

    @Test
    public void selectAll() {
        System.out.println(noticeDao.selectAll());
    }

    @Test
    public void delete() {
        System.out.println(noticeDao.delete(13));
    }
}
