package com.cloud.eureka.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.eureka.entity.User;
import com.cloud.eureka.entity.UserModel;
import com.cloud.eureka.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:29
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    public Page<UserModel> selectUserListPage(String name, Integer curr, Integer nums) {
        Page<UserModel> page = new Page<>(curr, nums);// 当前页，总条数 构造 page 对象
        page.setRecords(this.baseMapper.selectPageList(page, name));
        return page;
    }

}
