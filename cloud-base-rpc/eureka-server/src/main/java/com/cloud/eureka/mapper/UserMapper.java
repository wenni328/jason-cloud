package com.cloud.eureka.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.eureka.entity.User;
import com.cloud.eureka.entity.UserModel;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:28
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserModel> selectPageList(Page page, @Param("name") String name);
}
