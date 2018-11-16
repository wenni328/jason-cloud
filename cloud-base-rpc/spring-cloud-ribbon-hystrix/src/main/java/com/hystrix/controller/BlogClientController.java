package com.hystrix.controller;

import com.alibaba.fastjson.JSONObject;
import com.hystrix.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/9/3 18:04
 * @Description:
 */
@RestController
@RequestMapping("/client")
@Slf4j
public class BlogClientController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping(value = "/hi")
    public Object hi() {
        return hystrixService.hiService();
    }

    @PostMapping("/listTest")
    public Object listParam(@RequestBody List<Integer> list) {
        log.info(JSONObject.toJSONString(list));
        return null;
    }
}
