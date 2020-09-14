package com.juju.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author juju
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentProviderApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderApplication8002.class,args);
    }
}
