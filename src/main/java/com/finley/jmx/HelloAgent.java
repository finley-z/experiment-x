<<<<<<< HEAD
package com.finley.jmx;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.rmi.registry.LocateRegistry;

/**
 * @author zyf
 * @date 2017/8/28
 */
public class HelloAgent {
    public static void main(String[] args) throws JMException, Exception
       {
           String DOMAIN = "localhost";
           // 创建一个MBeanServer
           MBeanServer server = MBeanServerFactory.createMBeanServer(DOMAIN);
           // 用MBeanServer注册LoginStatsMBean
           // MBeanServer.registerMBean(Object，ObjectName)方法使用的参数有两个：一个是MBean实现的一个实例；另一个是类型ObjectName的一个对象-它用于唯一地标识该MBean
           server.registerMBean(new Hello(), new ObjectName(DOMAIN + ":name=statusBean"));
           // 存取该JMX服务的URL：
           JMXServiceURL url = new JMXServiceURL("rmi", "127.0.0.1", 9589, "/jndi/rmi://localhost:" + 1099 + "/app");
           // start()和stop()来启动和停止 JMXConnectorServer
           JMXConnectorServer jmxServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
           // 在RMI上注册
           LocateRegistry.createRegistry(1099);
           Thread.sleep(60*60*1000);
         }
}
=======
package com.finley.jmx;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author zyf
 * @date 2017/8/28
 */
public class HelloAgent {
    public static void main(String[] args) throws JMException, Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60 * 60 * 1000);
    }
}
>>>>>>> ae1fda4d7af7738be4f60e17e3c5535f6452d6d7
