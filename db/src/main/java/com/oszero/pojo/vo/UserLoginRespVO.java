package com.oszero.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserLoginRespVO implements Serializable {
    /**
     * 账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * TOKEN value;
     */
    private String token;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
