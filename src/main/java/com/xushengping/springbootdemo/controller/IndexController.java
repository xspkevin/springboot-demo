package com.xushengping.springbootdemo.controller;

import com.xushengping.springbootdemo.entities.Result;
import com.xushengping.springbootdemo.entities.dto.UserDTO;
import com.xushengping.springbootdemo.entities.form.UserDetailForm;
import com.xushengping.springbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String projectName;

    @Value("${spring.application.version}")
    private String version;

    @Value("${title}")
    private String title;

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/")
    public String hello() {
        return projectName + " " + title + " " + version;
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @RequestMapping("get_user_list")
    public @ResponseBody Result getUserList() {
        List<UserDTO> responseList = userServiceImpl.getUserList();
        return Result.OK(responseList);
    }

    /**
     * 根据手机号码获取用户详情
     *
     * @param form
     * @return
     */
    @RequestMapping(value = "get_user_detail", method = RequestMethod.POST)
    public @ResponseBody Result getUserDetail(@RequestBody @Validated UserDetailForm form) {
        UserDTO userDetail = userServiceImpl.getUserDetail(form.getPhone());
        return Result.OK(userDetail);
    }
}
