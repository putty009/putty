package com.chong.usermanagefeign.service;

import com.chong.userapi.service.UserManageService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * feign继承的方式不适合迭代开发
 * */
//@FeignClient(value = "USER", configuration=DisableHystrixConfiguration.class) //指定配置类
@FeignClient(value = "USER")
public interface RefactorUserManageService extends UserManageService {

}
