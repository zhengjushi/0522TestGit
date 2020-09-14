package com.juju.springcloud.serivce.impl;

import com.juju.springcloud.dao.PaymentMapper;
import com.juju.springcloud.entities.Payment;
import com.juju.springcloud.serivce.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author juju
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentMapper.findById(id);
    }
}
