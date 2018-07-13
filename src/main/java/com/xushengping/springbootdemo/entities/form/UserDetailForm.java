package com.xushengping.springbootdemo.entities.form;

import javax.validation.constraints.NotBlank;

/**
 * 根据手机号码获取用户详情
 */
public class UserDetailForm {

    @NotBlank(message = "手机号码不能为空！")
    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
