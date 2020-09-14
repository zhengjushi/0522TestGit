package com.juju.springcloud.controller;

import com.juju.springcloud.entities.CommonResult;
import com.juju.springcloud.entities.Payment;
import com.juju.springcloud.serivce.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/payment/add")
    public CommonResult<Payment> add(@RequestBody final Payment payment) {
        final int result = paymentService.addPayment(payment);
        log.info("插入结果为 ==> " + result);
        if (result > 0) {
            return new CommonResult<>(200, "添加成功 ==> " + serverPort);
        } else {
            return new CommonResult<>(444, "添加失败 ==> " + serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") final Long id) {
        final Payment payment = paymentService.findById(id);
        log.info("插入结果为 ==> "+payment);
        if (payment != null){
            return new CommonResult<>(200,"查询成功 ==> "+serverPort,payment);
        }else {
            return new CommonResult<>(444,"查询失败，没有对应的记录 ==> "+serverPort);
        }
    }
}
