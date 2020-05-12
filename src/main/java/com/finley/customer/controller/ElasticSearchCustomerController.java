package com.finley.customer.controller;


import com.finley.customer.entity.CustomerDetail;
import com.finley.customer.entity.CustomerInfo;
import com.finley.customer.entity.ESCustomer;
import com.finley.customer.service.ElasticSearchCustomerService;
import framework.spring.mvc.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 郑远锋 on 2017/3/5.
 */

@Controller
@RequestMapping(value = "/escustomer")
public class ElasticSearchCustomerController {
    @Autowired
    ElasticSearchCustomerService elasticSearchCustomerService;


    @RequestMapping(value = "add_customer")
    @ResponseBody
    public ResultVo saveCustomer(CustomerDetail customerInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            ESCustomer esCustomer=new ESCustomer(1,1901,"finley","小锋锋","13027236862","573108440@qq.com","计算机","深圳");
            elasticSearchCustomerService.addCustomer(esCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setStatus(false);
            resultVo.setErrorMsg(e.getMessage());
        }
        return resultVo;
    }

    @RequestMapping(value = "complete_customer")
    @ResponseBody
    public ResultVo completeCustomer(CustomerDetail customerInfo) {
        ResultVo resultVo = new ResultVo();
        try {
            resultVo.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setStatus(false);
            resultVo.setErrorMsg(e.getMessage());
        }
        return resultVo;
    }



    /***
     * 查找客户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get_customers")
    public List<ESCustomer> getCustomer(Integer customerId) {
        return elasticSearchCustomerService.getCustomers(null);
    }


}
