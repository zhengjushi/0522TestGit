package com.juju.springcloud.controller;

import com.juju.springcloud.entities.CommonResult;
import com.juju.springcloud.entities.Payment;
import com.juju.springcloud.serivce.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juju
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/add")
    public CommonResult<Payment> add(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        log.info("插入结果为 ==> "+result);
        if (result > 0){
            return new CommonResult<>(200,"添加成功 ==> " + serverPort);
        }else {
            return new CommonResult<>(444,"添加失败 ==> " + serverPort);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        log.info("插入结果为 ==> "+payment);
        if (payment != null){
            return new CommonResult<>(200,"查询成功 ==> " +serverPort,payment);
        }else {
            return new CommonResult<>(444,"查询失败，没有对应的记录 ==> "+serverPort);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //拿到所有注册信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**** service: "+service);
        }

        //拿到指定服务名称的所有的服务注册信息比如pay模块，他们两个的名字都是一样的，所以返回的是一个list
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
