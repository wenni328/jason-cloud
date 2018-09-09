package com.cloud.eureka.client.service;

import com.cloud.eureka.client.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xieyong
 * @date: 2018/9/3 18:02
 * @Description:
 */
@Service
public class BlogService {
    @Autowired
    RestTemplate restTemplate;

    public Object hiService() {
        return restTemplate.getForObject("http://SERVICE8081/testPage",User.class);
    }
}
