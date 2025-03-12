package com.oszero.aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  //运行时生效
@Target({ElementType.METHOD}) //方法级别注解
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return String
     */
    String description() default "";
}
