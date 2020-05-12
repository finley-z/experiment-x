package framework.spring;

import com.finley.customer.entity.ESCustomer;
import com.finley.customer.service.ElasticSearchCustomerService;
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

//        AOPTest aopTest= (AOPTest) context.getBean("aopTest");

        ElasticSearchCustomerService elasticSearchCustomerService= (ElasticSearchCustomerService) context.getBean("elasticSearchCustomerService");

        ESCustomer esCustomer=new ESCustomer(2,1901,"xiao feng feng","finley","13027236862","573108440@qq.com","计算机","深圳");
//        elasticSearchCustomerService.addCustomer(esCustomer);
       System.out.println("result: "+ elasticSearchCustomerService.getCustomers(null));
    }

}
