package com.cloud.eureka.client.service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.eureka.client.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/9/3 18:02
 * @Description:
 */
@Service
@Slf4j
public class BlogService {
    @Autowired
    @Qualifier("restTemplatePlus")
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    public Object hiService() {
        log.info("123");
        //返回是String--之前是User，一直都出错server-mybatis-plus
        String json=restTemplate.getForObject("http://SERVER-MYBATIS-PLUS/server/list",String.class);
        List<User> list=JSONObject.parseArray(json,User.class);
        for (User u:list) {
            log.info(JSONObject.toJSONString(u));
        }
        return json;
    }
}
