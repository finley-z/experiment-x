package framework.spring.containerEvent;

import org.springframework.context.ApplicationEvent;

public class RechargeEvent extends ApplicationEvent {
    RechargeEventEnum eventType;
    private String orderId;
    public RechargeEvent(Object source,RechargeEventEnum type,String orderId) {
        super(source);
        this.eventType=type;
        this.orderId=orderId;
    }

    public RechargeEventEnum getEventType() {
        return eventType;
    }

    public void setEventType(RechargeEventEnum eventType) {
        this.eventType = eventType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
