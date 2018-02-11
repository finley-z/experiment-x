package framework.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author zyf
 * @date 2018/1/9
 */
public class SqlSessionHolder {
    public static SqlSession getSession(){
        String config="config/mybatis.xml";
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession();
    }

    public static void main(String []args){
        SqlSession sqlSession=SqlSessionHolder.getSession();
        sqlSession.update("com.finley.database.dao.DataBaseTestDao.updateTest1",1);

    }

}
