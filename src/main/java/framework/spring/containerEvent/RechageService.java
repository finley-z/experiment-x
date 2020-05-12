package framework.spring.containerEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RechageService implements ApplicationContextAware{

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }

    public void recharge(){
        System.out.println("rechaging the order ....");
        RechargeEvent rechargeEvent=new RechargeEvent(this.context,RechargeEventEnum.RECIVER,"232323");
        context.publishEvent(rechargeEvent);
    }

    public void callback(){
        System.out.println("callback the order ....");
        RechargeEvent rechargeEvent=new RechargeEvent(this.context,RechargeEventEnum.CALLBACK,"324234");
        context.publishEvent(rechargeEvent);
    }
}
