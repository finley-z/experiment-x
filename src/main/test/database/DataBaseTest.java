package database;

import com.finley.database.dao.DataBaseTestDao;
import com.finley.database.service.DataBaseTestEntrace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ö£Ô¶·æ on 2017/8/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:config/application_context.xml",
        "classpath:config/mybatis_config.xml"
})
public class DataBaseTest {
    @Autowired
    private DataBaseTestDao dataBaseTestDao;
    @Autowired
    private DataBaseTestEntrace testBean;


    @Test
    public void testDeadlock(){
        testBean.execute();
    }

}
