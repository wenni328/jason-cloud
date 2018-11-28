package com.cloud.eureka.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:21
 * @Description:  公共字段的插入与更新操作都可以设置
 */
@Component
@Slf4j
public class MetaObjectHandlerConfig implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入方法实体填充");
        setFieldValByName("salt", "md5", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新方法实体填充");
    }
}