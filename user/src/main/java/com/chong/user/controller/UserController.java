package com.chong.user.controller;

import com.chong.puttycommon.po.User;
import com.chong.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    //@RequestMapping("/sample")
    @GetMapping("/sample/{id}")
    public User sample(HttpServletRequest request, @PathVariable(name = "id") Integer id){
        return userService.selectById(id);
    }

    @PostMapping("/insert")
    public int insert(HttpServletRequest request, User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public int insert(HttpServletRequest request, @PathVariable(name = "id") Integer id){
        return userService.deletebyId(id);
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        /*int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime: "+sleepTime);
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e) {}*/
        return "hello";
    }

    @GetMapping("/helloName")
    public String hello(HttpServletRequest request, @RequestParam String name){
        return "hello"+name;
    }

    @PostMapping("/helloUser")
    public String hello(HttpServletRequest request, @RequestBody User user){
        return "hello"+user.getUserId()+", "+user.getUserName();
    }

}