package com.chong.usermanage.controller;

import com.chong.usermanage.Service.UserManageService;
import com.chong.usermanage.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/userManage")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    @GetMapping(value = "/sample/{id}")
    public User sample(@PathVariable(name = "id") Integer id) {
        System.out.println("hello service");
        return userManageService.sample(id);
    }




    @GetMapping(value = "/test")
    public String test(Integer id) {
        System.out.println("do");
        return "test";
    }

    @PostMapping(value = "/page")
    public String page() {
        //1
        //ResponseEntity<String> entity = restTemplate.postForEntity("http://USER-SERVICE/hello",Object obj, String.class);
        //String body = entity.getBody();

        //2
        //String forObject = restTemplate.postForObject("http://USER-SERVICE/hello",Object obj, String.class);
        //return body;
        return "This is a postMapping";
    }

    /*
    @RequestMapping(value = "/cache-test", method = RequestMethod.GET)
    public String test() {
        //分析发现，只有在一次请求中对同一个服务多次调用才会使用缓存，在实际中几乎没有使用的价值
        String s1 = helloService.cacheTest("1");
        String s2 = helloService.cacheTest("1");
        System.out.println(s1);
        System.out.println(s2);
        return s2;
        //return restTemplate.getForEntity("http://USER-service/hello",String.class).getBody();
    }


    *//*不生效*//*
    @GetMapping("/info")
    public String diyInfo() {
        System.out.println("info");
        return "consumer info";
    }*/
}
