package com.hzit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.hzit.api.service") //扫描是FeginClients所在的包
@ComponentScan({"com.hzit.consumer","com.hzit.api.factoy"}) //手动扫描
public class DeptConsumerFegin81 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFegin81.class, args);
    }

}
