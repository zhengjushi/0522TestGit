package com.juju.springcloud.dao;

import com.juju.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author juju
 */
@Mapper
@Component
public interface PaymentMapper {
    /**
     * 添加支付信息
     * @param payment
     * @return
     */
    int addPayment(Payment payment);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Payment findById(Long id);

}