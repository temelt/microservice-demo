package com.temelt.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Project microservice-demo
 * Created by taner on 05.03.2019
 */
@EnableHystrixDashboard
@SpringBootApplication
//@EnableEurekaClient
public class HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class, args);
    }
}
