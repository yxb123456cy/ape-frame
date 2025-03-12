package com.oszero.pojo.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserFindDTO implements Serializable {
    /**
     * 用户ID;
     */
    private Long id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
