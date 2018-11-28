package com.cloud.eureka.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: xieyong
 * @date: 2018/11/9 17:32
 * @Description:
 */
@Data
public class UserModel {
    private Long id;

    private String name;

    private String password;

    private String salt;

    private String title;

    private String author;

    private Integer authorId;

    private String content;

    private String html;


    private Date createTime;

    private String mark;

    private String sorts;

    private String picture;

}
