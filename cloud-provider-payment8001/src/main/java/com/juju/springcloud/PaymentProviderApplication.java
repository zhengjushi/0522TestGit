package com.juju.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author juju
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderApplication.class,args);
    }
}