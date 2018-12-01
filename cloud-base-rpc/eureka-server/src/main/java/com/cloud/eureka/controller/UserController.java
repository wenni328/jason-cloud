package com.cloud.eureka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.eureka.entity.ParamsModel;
import com.cloud.eureka.entity.User;
import com.cloud.eureka.entity.UserModel;
import com.cloud.eureka.mapper.UserMapper;
import com.cloud.eureka.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:30
 * @Description:
 */
@RestController
@RequestMapping("/server")
@Slf4j
public class UserController extends ApiController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/testPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public IPage<User> testPage() {
        log.info("访问底层[testPage]接口,参数：{},{}",1,12);
        return userService.page(new Page<>(1, 12), null);
    }

    @GetMapping(value = "/getUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getById() {
        return userMapper.selectById(1);
    }

    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> list() {
        return userMapper.selectList(new QueryWrapper<User>().lambda().and(e -> e.between(User::getId, 1, 20)));
//        return userMapper.selectList(new QueryWrapper<User>()
//                .lambda().eq(User::getName, "admin")
//                .and(e -> e.like(User::getPassword, "adm"))
//                .and(e -> e.between(User::getId, "4", "20")));
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping(value = "/page")
    public Page<UserModel>  page(@RequestBody ParamsModel paramsModel) {
        log.info("访问底层[page]接口,参数：{}", com.alibaba.fastjson.JSONObject.toJSONString(paramsModel));
        return userService.selectUserListPage(paramsModel.getName(),paramsModel.getCurr(),paramsModel.getNums());
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean update(@RequestBody User user) {
        User u = new User();
        u.setId(12L);
        return userService.update(user, new UpdateWrapper<>(u));
    }

}
