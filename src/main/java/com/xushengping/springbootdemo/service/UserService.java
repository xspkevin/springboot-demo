package com.xushengping.springbootdemo.service;

import com.xushengping.springbootdemo.entities.dto.UserDTO;

import java.util.List;

public interface UserService {

    /**
     * 获取用户列表
     *
     * @return
     */
    List<UserDTO> getUserList();

    /**
     * 根据手机号码获取用户详情
     *
     * @param phone
     * @return
     */
    UserDTO getUserDetail(String phone);
}
