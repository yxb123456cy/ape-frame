package com.oszero.controller;

import com.oszero.aspect.ApiOperationLog;
import com.oszero.entity.User;
import com.oszero.pojo.dto.UserFindDTO;
import com.oszero.pojo.dto.UserLoginDTO;
import com.oszero.pojo.dto.UserRegisterDTO;
import com.oszero.pojo.vo.UserLoginRespVO;
import com.oszero.response.Response;

import com.oszero.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //登录;
    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录")
    public Response<UserLoginRespVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    //注销登录;
    @PostMapping("/logout")
    @ApiOperationLog(description = "注销登录")
    public Response<Boolean> logout() {
        return userService.logout();
    }

    //注册;
    @PostMapping("/register")
    @ApiOperationLog(description = "注册")
    public Response<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }

    //根据ID获取User;
    @PostMapping("/info")
    @ApiOperationLog(description = "根据ID获取User")
    public Response<User> getByID(@RequestBody UserFindDTO userFindDTO) {
        return userService.getUserById(userFindDTO);
    }


}
