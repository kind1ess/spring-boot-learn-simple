package com.kind1ess.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {

    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
