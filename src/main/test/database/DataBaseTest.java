package database;

import com.finley.database.service.DataBaseTestEntrace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ֣Զ�� on 2017/8/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:config/application_context.xml",
        "classpath:config/spring-mvc.xml",
        "classpath:config/mybatis_config.xml"
})
public class DataBaseTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DataBaseTestEntrace testBean;


    @Test
    public void testDeadlock(){
        testBean.execute();
    }

}
