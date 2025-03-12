package com.oszero.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserFindDTO implements Serializable {
    /**
     * 用户ID;
     */
    private Long id;


    private static final long serialVersionUID = 1L;
}
