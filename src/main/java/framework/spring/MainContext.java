package framework.spring;

import framework.spring.aop.AOPTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyf
 * @date 2017/12/11
 */
public class MainContext {
    public static void main(String []args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:framework/spring/beans.xml");

//        Car car= (Car) context.getBean("car");
//        System.out.println(car.getBrand());
//        car.introduce();

//        RechageService rechageService= (RechageService) context.getBean("rechageService");
//        rechageService.callback();
//        rechageService.recharge();

        AOPTest aopTest= (AOPTest) context.getBean("aopTest");
        aopTest.before();
    }

}
