package framework.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2018/1/15
 */
@Service
public class AOPTest {

    @advice
    public void before(){
        System.out.println("test aop");
    }
}
