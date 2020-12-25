package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentSerivce;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

public class PaymentController {
  @Resource
  private PaymentSerivce paymentSerivce;
  @Value("${server.port}")
  private String serverPort;
  @PostMapping(value = "/payment/create")
  public CommonResult<Payment> create (@RequestBody Payment payment){
    int result = paymentSerivce.create(payment);
    log.info("插入结果:"+result) ;
    if(result>0){
      return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
    }else{
      return new CommonResult(444,"插入数据库失败",null);
    }
  }

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById (@PathVariable("id") Long id){
    Payment payment = paymentSerivce.getPaymentById(id);
    log.info("插入结果:"+payment);
    if(payment!=null){
      return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
    }else{
      return new CommonResult(444,"没有对应记录，查询ID："+id,null);
    }
  }
}
