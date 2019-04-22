package framework.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author zyf
 * @date 2018/1/17
 */

@Controller
public class RegisterController {


    @RequestMapping(value = "index")
    public String register(){
        return "/index";
    }

    @RequestMapping(value = "register")
    @ResponseBody
    public ResultVo register(@Valid User user, BindingResult result){
            ResultVo resultVo =new ResultVo(false);
            System.out.println("注册测试中");
            if(result.getFieldErrors()!=null&&result.getFieldErrors().size()>0){
                resultVo.setValidateMessage(result.getFieldErrors());
            }
        return resultVo;
    }
}
