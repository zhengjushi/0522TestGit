package com.juju.springcloud.service;

import com.juju.springcloud.entities.CommonResult;
import com.juju.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient(value = "cloud_payment-service")
 * value: 指定服务提供者的服务名称
 * @author juji
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeign {

    /**
     * 调用此方法可以调用到 服务提供者的同名方法
     * @param id 传入的id
     * @return 返回CommonResult 对象
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> findById(@PathVariable("id") Long id);
}
