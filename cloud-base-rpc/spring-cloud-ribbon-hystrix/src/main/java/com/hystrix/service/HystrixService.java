package com.hystrix.service;

import com.alibaba.fastjson.JSONObject;
import com.hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/11/12 19:26
 * @Description:
 */
@Service
@Slf4j
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    //@HystrixCommand(fallbackMethod = "fallback")
    public Object hiService() {
        //返回是String--之前是User，一直都出错
        String json = restTemplate.getForObject("http://SERVER-MYBATIS-PLUS/plus/list", String.class);
        List<User> list = JSONObject.parseArray(json, User.class);
        for (User u : list) {
            log.info(JSONObject.toJSONString(u));
        }
        return json;
    }

    public String fallback() {
        return "fallback";
    }
}
