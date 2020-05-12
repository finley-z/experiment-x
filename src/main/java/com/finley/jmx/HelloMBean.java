package com.finley.jmx;

/**
 * @author zyf
 * @date 2017/10/31
 */
public interface HelloMBean {
       public String getName();

       public void setName(String name);

       public String getAge();

        public void setAge(String age);

        public void helloWorld();

        public void helloWorld(String str);

        public void getTelephone();

}
