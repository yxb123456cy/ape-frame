package com.oszero.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oszero.entity.User;
import com.oszero.enums.ResponseCodeEnum;
import com.oszero.exception.BizException;
import com.oszero.pojo.dto.UserFindDTO;
import com.oszero.pojo.dto.UserLoginDTO;
import com.oszero.pojo.dto.UserRegisterDTO;
import com.oszero.pojo.vo.UserLoginRespVO;
import com.oszero.response.Response;
import com.oszero.service.UserService;
import com.oszero.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【user(用户信息表)】的数据库操作Service实现
 * @createDate 2025-03-12 13:58:51
 */


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private UserMapper mapper;


    @Override
    public Response<UserLoginRespVO> login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        User user = getOne(queryWrapper);
        if (user != null) {
            //存在;
            if (user.getPassword().equals(userLoginDTO.getPassword())) {
                //比对成功;登录;
                UserLoginRespVO data = new UserLoginRespVO();
                //saToken登录;
                StpUtil.login(user.getId());
                String tokenValue = StpUtil.getTokenInfo().getTokenValue();
                data.setId(user.getId()).setUsername(user.getUsername()).setToken(tokenValue);
                return Response.success(data);
            } else {
                throw new BizException(ResponseCodeEnum.PASSWORD_ERROR);
            }
        } else {
            throw new BizException(ResponseCodeEnum.USER_NOT_EXISTS);
        }
    }

    @Override
    public Response<Boolean> logout() {
        StpUtil.logout();
        return Response.success(true);
    }

    @Override
    public Response<Boolean> register(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        String password = userRegisterDTO.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        User DBuser = getOne(queryWrapper);
        if (DBuser != null) {
            throw new BizException(ResponseCodeEnum.USER_HAVE_EXISTS);
        } else {
            User user = User.builder().username(username).password(password).name("").build();
            boolean saved = save(user);
            if (!saved) {
                throw new BizException(ResponseCodeEnum.USER_REGISTER_ERROR);
            }
            log.info("{}注册账号成功", username);
            return Response.success(true);
        }

    }

    @Override
    public Response<User> getUserById(UserFindDTO userFindDTO) {
        Long id = userFindDTO.getId();
        User user = getById(id);
        return Response.success(user);
    }


}




