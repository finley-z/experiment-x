package com.finley.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

public class Agent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        
        //创建MBean并注册
        server.registerMBean(new Demo(), new ObjectName("mybean:name=xxx"));

        //创建一个web适配器服务器，表示我们MBean服务通过web形式来提供给用户管理.
        //该web server本身也是一个MBean，也需要被注册. 参数是web服务器的端口号，默认是8082
//        HtmlAdaptorServer htmlServer = new HtmlAdaptorServer(9999);
//        server.registerMBean(htmlServer, new ObjectName("Agent:name=htmlServer"));
//
//        启动web服务器，这样浏览器通过 http://localhost:9999/ 就可以访问和操作这些Mbean
//        htmlServer.start();

    }

}