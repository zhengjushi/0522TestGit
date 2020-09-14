package com.juju.springcloud.serivce;

import com.juju.springcloud.entities.Payment;

/**
 * @author juju
 */
public interface PaymentService {

    /**
     * 添加支付的业务方法
     * @param payment
     * @return
     */
    int addPayment(Payment payment);

    /**
     * 根据id查询支付的业务方法
     * @param id
     * @return
     */
    Payment findById(Long id);
}
