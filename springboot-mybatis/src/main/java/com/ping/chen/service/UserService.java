package com.ping.chen.service;

import com.ping.chen.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 查询列表
     * @return
     */
    List<UserEntity> getUserList();
}
