package com.juju.springcloud.serivce;

import com.juju.springcloud.entities.Payment;

/**
 * @author juju
 */
public interface PaymentService {

    /**
     * 添加支付的业务方法
     * @param payment  传入一个 Payment 对象
     * @return 返回是否添加成功，成功为 1，失败为 0
     */
    int addPayment(Payment payment);

    /**
     * 根据id查询支付的业务方法
     * @param id 传入的id
     * @return  返回一个 Payment 对象
     */
    Payment findById(Long id);
}
