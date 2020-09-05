package com.ping.chen.service.impl;

import com.ping.chen.entity.UserEntity;
import com.ping.chen.mapper.UserMapper;
import com.ping.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getUserList() {
        return userMapper.getUserList();
    }
}
