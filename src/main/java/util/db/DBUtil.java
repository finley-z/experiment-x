<<<<<<< HEAD
package util.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Ö£Ô¶·æ on 2017/8/2.
 */
public class DBUtil {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;
    private static Connection connection;

    static{
        //¼ÓÔØÊı¾İ¿âÅäÖÃĞÅÏ¢£¬²¢¸øÏà¹ØµÄÊôĞÔ¸³Öµ
        loadConfig();
    }

    /**
     * ¼ÓÔØÊı¾İ¿âÅäÖÃĞÅÏ¢£¬²¢¸øÏà¹ØµÄÊôĞÔ¸³Öµ
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
            throw new RuntimeException("¶ÁÈ¡Êı¾İ¿âÅäÖÃÎÄ¼şÒì³££¡", e);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver); // ×¢²áÇı¶¯
            connection = DriverManager.getConnection(url, userName, password); // »ñÈ¡Á¬½Ó
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

}
=======
package util.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by éƒ‘è¿œé”‹ on 2017/8/2.
 */
public class DBUtil {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;
    private static Connection connection;

    static{
        //åŠ è½½æ•°æ®åº“é…ç½®ä¿¡æ¯ï¼Œå¹¶ç»™ç›¸å…³çš„å±æ€§èµ‹å€¼
        loadConfig();
    }

    /**
     * åŠ è½½æ•°æ®åº“é…ç½®ä¿¡æ¯ï¼Œå¹¶ç»™ç›¸å…³çš„å±æ€§èµ‹å€¼
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
            throw new RuntimeException("è¯»å–æ•°æ®åº“é…ç½®æ–‡ä»¶å¼‚å¸¸ï¼", e);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver); // æ³¨å†Œé©±åŠ¨
            connection = DriverManager.getConnection(url, userName, password); // è·å–è¿æ¥
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

}
>>>>>>> ae1fda4d7af7738be4f60e17e3c5535f6452d6d7
