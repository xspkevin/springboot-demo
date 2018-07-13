package com.xushengping.springbootdemo.repository;

import com.xushengping.springbootdemo.entities.dto.UserDTO;

import java.util.List;

public interface UserDao {

    /**
     * 获取用户列表
     *
     * @return
     */
    List<UserDTO> getUserList();

    /**
     * 根据手机号码获取用户信息
     *
     * @param phone
     * @return
     */
    UserDTO getUserDetail(String phone);
}
