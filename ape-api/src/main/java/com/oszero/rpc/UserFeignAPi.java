package com.oszero.rpc;

import com.oszero.constants.ApplicationConstants;
import com.oszero.domain.User;
import com.oszero.domain.UserFindDTO;
import com.oszero.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.oszero.constants.FeignConstants.USER_SERVICE_PREFIX;

@FeignClient(name = ApplicationConstants.USER_APPLICATION_NAME)
public interface UserFeignAPi {
    //根据ID获取User;
    @GetMapping(USER_SERVICE_PREFIX + "/info")
    Response<User> getByID(@RequestBody UserFindDTO userFindDTO);
}
