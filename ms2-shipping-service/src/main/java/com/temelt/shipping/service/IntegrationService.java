package com.temelt.shipping.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Project microservice-demo
 * Created by taner on 31.01.2019
 */
@Service
public class IntegrationService {

    private final LoadBalancerClient loadBalancerClient;

    public IntegrationService(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @PostConstruct
    public void init() {
        ServiceInstance instance = loadBalancerClient.choose("ms3-inventory-service");
        System.out.println(instance);
    }

}
