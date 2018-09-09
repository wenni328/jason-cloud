package com.cloud.eureka.client.controller;

import com.cloud.eureka.client.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xieyong
 * @date: 2018/9/3 18:04
 * @Description:
 */
@RestController
@RequestMapping("/client")
public class BlogClientController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/hi")
    public Object hi() {
        return blogService.hiService();
    }
}
