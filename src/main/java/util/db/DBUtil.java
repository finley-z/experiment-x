package util.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by 郑远锋 on 2017/8/2.
 */
public class DBUtil {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;
    private static Connection connection;

    static{
        //加载数据库配置信息，并给相关的属性赋值
        loadConfig();
    }

    /**
     * 加载数据库配置信息，并给相关的属性赋值
     */
    public static void loadConfig() {
        try {
            InputStream inStream = DBUtil.class
                    .getResourceAsStream("/config/jdbc.properties");
            Properties prop = new Properties();
            prop.load(inStream);
            userName = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            driver= prop.getProperty("jdbc.driver");
            url = prop.getProperty("jdbc.url");
        } catch (Exception e) {
            throw new RuntimeException("读取数据库配置文件异常！", e);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver); // 注册驱动
            connection = DriverManager.getConnection(url, userName, password); // 获取连接
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

}
