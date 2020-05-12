package framework.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zyf
 * @date 2018/1/15
 */

@Component
@Aspect
public class AopComponent {

    @Before(value = "@annotation(framework.spring.aop.advice)")
    public void before(JoinPoint joinPoint){
        System.out.println("调用"+joinPoint.getTarget());
    }

}
