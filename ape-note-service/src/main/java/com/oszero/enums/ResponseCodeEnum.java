package com.oszero.enums;


import com.oszero.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    USER_HAVE_EXISTS("500", "该用户已注册!"),
    USER_NOT_EXISTS("500","该用户不存在" ),
    PASSWORD_ERROR("500","密码错误" ),
    USER_REGISTER_ERROR("500", "系统错误,用户注册失败!"),
    NOTE_PUBLISH_ERROR("500","系统错误,笔记发布失败" );

    // ----------- 业务异常状态码 -----------
    ;


    // 异常码
    private final String errorCode;
    // 错误信息
    private final String errorMessage;
}
