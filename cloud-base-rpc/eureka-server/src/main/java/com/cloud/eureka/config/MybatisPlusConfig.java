package com.cloud.eureka.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:24
 * @Description:
 */

@Configuration
@MapperScan("com.cloud.eureka.mapper*")
@Slf4j
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     * Time：243 ms - ID：com.cloud.eureka.mapper.UserMapper.selectList
     * Execute SQL：SELECT id,name,password,salt FROM user WHERE ( id BETWEEN 1 AND 20 )
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
