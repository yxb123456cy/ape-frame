package com.oszero.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserRegisterDTO implements Serializable {
    /**
     * 账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
