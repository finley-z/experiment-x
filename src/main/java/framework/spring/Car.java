package framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author zyf
 * @date 2017/12/11
 */
public class Car implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean {
    private String brand;
    private Integer color;

    public Car(){
        System.out.println("....调用Car的构造函数.....");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("....调用BeanFactoryAware setBeanFactory函数.....");

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("....调用BeanNameAware setBeanName.....");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("....调用DisposableBean destroy.....");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("....调用InitializingBean afterPropertiesSet.....");

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("....调用setBrand（）方法设置属性.....");
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        System.out.println("....调用setColor()方法设置属性.....");
    }

    public void myInit(){
        System.out.println("初始化");
    }

    public void myDestroy(){
        System.out.println("销毁");
    }

    public void introduce(){
        System.out.println("启动测试");
    }
}
