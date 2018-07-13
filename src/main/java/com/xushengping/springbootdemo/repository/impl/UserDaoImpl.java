package com.xushengping.springbootdemo.repository.impl;

import com.xushengping.springbootdemo.entities.dto.UserDTO;
import com.xushengping.springbootdemo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate userJdbcTemplate;

    @Override
    public List<UserDTO> getUserList() {
        List<UserDTO> resultList = userJdbcTemplate.query("SELECT user_id, username, phone, created_at AS register_time FROM user", new BeanPropertyRowMapper(UserDTO.class));
        return resultList;
    }

    @Override
    public UserDTO getUserDetail(String phone) {
        List<UserDTO> resultList = userJdbcTemplate.query("SELECT user_id, username, phone, created_at AS register_time FROM user WHERE phone = ? LIMIT 1", new Object[]{phone}, new BeanPropertyRowMapper(UserDTO.class));
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
}
