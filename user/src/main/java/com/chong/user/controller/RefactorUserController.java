package com.chong.user.controller;

import com.chong.userapi.po.User;
import com.chong.userapi.service.UserManageService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorUserController implements UserManageService {

    @Override
    public String hello(@RequestParam String name) {
        return "hello"+name;
    }
    @Override
    public String hello(@RequestBody User user) {
        return "hello"+user.getUserId()+", "+user.getUserName();
    }
}
