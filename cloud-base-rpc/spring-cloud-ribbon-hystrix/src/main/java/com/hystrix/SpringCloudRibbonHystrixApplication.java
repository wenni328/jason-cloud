package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 点进去可以看到@SpringCloudApplication
 * 包含了好几个注解
 */
@SpringBootApplication
@EnableDiscoveryClient
//swagger文档
//@EnableSwagger2Doc
public class SpringCloudRibbonHystrixApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonHystrixApplication.class, args);
    }
}
