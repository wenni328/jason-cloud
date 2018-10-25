package com.cloud.feign.interfaces;

import com.cloud.feign.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: xieyong
 * @date: 2018/9/4 19:33
 * @Description:
 */
@FeignClient("eureka-server-1")
public interface AuthFeignClient {

    @GetMapping(value = "/plus/testPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Object getuserinfo();
}
