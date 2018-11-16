package com.cloud.eureka.client;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xieyong
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableSwagger2Doc
//@EnableHystrix
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


    /**
     * 加载注入--负载均衡
     * @return
     */
    @Bean("restTemplatePlus")
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // restTemplate.setErrorHandler(new ThrowErrorHandler());
        return restTemplate;
    }
}
