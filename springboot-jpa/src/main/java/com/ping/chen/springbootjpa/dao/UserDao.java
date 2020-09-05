package com.ping.chen.springbootjpa.dao;

import com.ping.chen.springbootjpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<UserEntity, String> {

    @Query("select  user from UserEntity  user where account = ?1")
    UserEntity getUserByAccount(String account);

    @Modifying
    @Query("update UserEntity user set user.name=?2, user.age=?3, user.addr=?4 where  user.id=?1")
    void updateUser(String id, String name, Integer age, String addr);

}
