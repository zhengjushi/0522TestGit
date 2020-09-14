package com.juju.springcloud.controller;

import com.juju.springcloud.entities.CommonResult;
import com.juju.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author juju
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
	public RestTemplate template;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") final Long id) {

        CommonResult<Payment> result = template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment) {
        return template.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }
}
