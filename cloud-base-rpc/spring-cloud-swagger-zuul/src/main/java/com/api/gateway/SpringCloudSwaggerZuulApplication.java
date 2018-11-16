package com.api.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Zuul默认已经整合了Hystrix
 */
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class SpringCloudSwaggerZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSwaggerZuulApplication.class, args);
    }
}
