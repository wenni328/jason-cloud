package com.cloud.eureka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.eureka.entity.User;
import com.cloud.eureka.mapper.UserMapper;
import com.cloud.eureka.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:30
 * @Description:
 */
@RestController
@RequestMapping("/plus")
public class UserController extends ApiController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/testPage")
    public IPage<User> testPage() {
        return userService.page(new Page<>(0, 12), null);
    }

    @GetMapping("/getUser")
    public User getById() {
        return userMapper.selectById(1);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userMapper.selectList(new QueryWrapper<User>()
                .lambda().eq(User::getName, "admin")
                .and(e -> e.like(User::getPassword, "adm"))
                .and(e -> e.between(User::getId, "4", "20")));

    }

    @PostMapping("/save")
    public Boolean save(@RequestBody User user) {
        return userService.save(user);
    }
}
