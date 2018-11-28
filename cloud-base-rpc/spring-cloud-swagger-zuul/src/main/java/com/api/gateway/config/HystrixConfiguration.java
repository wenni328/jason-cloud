package com.api.gateway.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xieyong
 * @date: 2018/11/16 14:43
 * @Description: 开启访问Hystri.stream入口
 */
@Configuration
public class HystrixConfiguration {

    @Bean(name = "hystrixRegistrationBean")
    public ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registration = new ServletRegistrationBean<>(
                new HystrixMetricsStreamServlet(), "/hystrix.stream");
        registration.setName("hystrixServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean(name = "hystrixForTurbineRegistrationBean")
    public ServletRegistrationBean<HystrixMetricsStreamServlet> servletTurbineRegistrationBean() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registration = new ServletRegistrationBean<>(
                new HystrixMetricsStreamServlet(), "/actuator/hystrix.stream");
        registration.setName("hystrixForTurbineServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
