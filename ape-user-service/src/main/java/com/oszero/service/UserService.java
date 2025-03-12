package com.oszero.service;

import com.oszero.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import com.oszero.pojo.dto.UserFindDTO;
import com.oszero.pojo.dto.UserLoginDTO;
import com.oszero.pojo.dto.UserRegisterDTO;
import com.oszero.pojo.vo.UserLoginRespVO;
import com.oszero.response.Response;

/**
* @author Administrator
* @description 针对表【user(用户信息表)】的数据库操作Service
* @createDate 2025-03-12 13:58:51
*/
public interface UserService extends IService<User> {


    Response<UserLoginRespVO> login(UserLoginDTO userLoginDTO);

    Response<Boolean> logout();

    Response<Boolean> register(UserRegisterDTO userRegisterDTO);

    Response<User> getUserById(UserFindDTO userFindDTO);
}
