package com.chong.usermanagefeign.service;

import com.chong.puttycommon.po.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/*当应用启动时扫描到配置类时，即会生效（关闭hystrix配置），会导致服务降级无效*/
//@FeignClient(value = "user-service", fallback = HelloServiceFallback.class, configuration = FullLoggerLevel.class)
@FeignClient(value = "user")
public interface UserManageService {

    /**
     * 这里的代码与服务提供发controller一致，可以使用feign的继承特性减少代码量
     * */
    @RequestMapping("/user/hello")
    String hello();
    @RequestMapping(value = "/user/helloName", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
    @RequestMapping(value = "/user/helloUser", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
