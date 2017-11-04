package com.finley.jmx;

/**
 * @author zyf
 * @date 2017/10/31
 */
public class Hello implements HelloMBean {
    private String name;

    private String age;

    public void getTelephone() {
        System.out.println("get Telephone");
    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public void helloWorld(String str) {
        System.out.println("helloWorld:" + str);
    }

    public String getName() {
        System.out.println("get name 123");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name 123");
        this.name = name;
    }

    public String getAge() {
        System.out.println("get age 123");
        return age;
    }

    public void setAge(String age) {
        System.out.println("set age 123");
        this.age = age;
    }
}
