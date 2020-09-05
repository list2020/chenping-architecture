package com.ping.chen.springbootjpa.service;

import com.ping.chen.springbootjpa.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> queryUsers();

    void saveUser(UserEntity userEntity);

    void editUser(UserEntity userEntity);

    void deleteUser(String id);

    String login(UserEntity userEntity);

    UserEntity queryUserById(String id);

    void updateUser(UserEntity userEntity);

}
