package com.hystrix.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: xieyong
 * @date: 2018/9/3 19:26
 * @Description:
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String password;

    private String salt;
}
