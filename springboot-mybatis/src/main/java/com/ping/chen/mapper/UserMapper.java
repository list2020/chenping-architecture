package com.ping.chen.mapper;

import com.ping.chen.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询用户列表
     * @return
     */
    List<UserEntity> getUserList();
}
