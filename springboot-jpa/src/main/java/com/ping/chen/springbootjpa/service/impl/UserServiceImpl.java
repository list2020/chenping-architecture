package com.ping.chen.springbootjpa.service.impl;

import com.ping.chen.springbootjpa.dao.UserDao;
import com.ping.chen.springbootjpa.entity.UserEntity;
import com.ping.chen.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> queryUsers() {
        List<UserEntity> userList = userDao.findAll();
        return userList;
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setBirth(new Date());
        userEntity.setId(UUID.randomUUID().toString());
        userDao.save(userEntity);
    }

    @Override
    public void editUser(UserEntity userEntity) {

    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }

    @Override
    public String login(UserEntity userEntity) {
        if(!userEntity.getPwd().equals(userEntity.getRepwd())){
            return "1";
        }
        /**
         * 查询是否存在
         */
        UserEntity user = userDao.getUserByAccount(userEntity.getAccount());
        if(null == user){
            return "2";
        }
        /**
         * 存在比对密码
         */
        if(!userEntity.getPwd().equals(user.getPwd())){
            return "3";
        }
        return "0";
    }

    @Override
    public UserEntity queryUserById(String id) {
        Optional<UserEntity> user = userDao.findById(id);
        return user.get();
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity.getId(), userEntity.getName(), userEntity.getAge(), userEntity.getAddr() );
    }
}
