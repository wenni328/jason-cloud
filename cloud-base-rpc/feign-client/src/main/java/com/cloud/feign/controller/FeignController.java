package com.cloud.feign.controller;

import com.cloud.feign.entity.User;
import com.cloud.feign.interfaces.AuthFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/10/23 15:39
 * @Description:
 */
@RestController
@RequestMapping("/feignclient")
public class FeignController {
    @Autowired
    private AuthFeignClient feignClient;

    @GetMapping(value = "/getUserInfo")
    public List<User> getUserInfo(){
        return feignClient.getuserinfo();
    }
}
