package com.juju.springcloud.controller;

import com.juju.springcloud.entities.CommonResult;
import com.juju.springcloud.entities.Payment;
import com.juju.springcloud.service.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juju
 */
@RestController
@Slf4j
public class ConsumerFeignController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        CommonResult<Payment> p = paymentFeign.findById(id);
        return p;
    }
}
