package framework.spring.containerEvent;

import org.springframework.context.ApplicationListener;

public class RechargeListener implements ApplicationListener<RechargeEvent> {
    @Override
    public void onApplicationEvent(RechargeEvent rechargeEvent) {
            RechargeEvent event=(RechargeEvent)rechargeEvent;

            if(event.eventType==RechargeEventEnum.CALLBACK){
                System.out.println("订单回调中，订单号："+event.getOrderId());
            }else if(event.eventType==RechargeEventEnum.RECIVER) {
                System.out.println("订单充值中，订单号："+event.getOrderId());
            }

    }
}
