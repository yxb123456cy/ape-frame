package com.oszero.controller;


import com.oszero.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //登录;
    //注销登录;
    //注册;
    //根据ID获取User;


}
