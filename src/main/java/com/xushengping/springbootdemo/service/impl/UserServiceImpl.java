package com.xushengping.springbootdemo.service.impl;

import com.xushengping.springbootdemo.entities.dto.UserDTO;
import com.xushengping.springbootdemo.repository.impl.UserDaoImpl;
import com.xushengping.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;


    @Override
    public List<UserDTO> getUserList() {
        List<UserDTO> resultList = userDaoImpl.getUserList();
        return resultList;
    }

    @Override
    public UserDTO getUserDetail(String phone) {
        UserDTO result = userDaoImpl.getUserDetail(phone);
        return result;
    }
}
