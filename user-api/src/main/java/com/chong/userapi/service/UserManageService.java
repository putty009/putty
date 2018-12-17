package com.chong.userapi.service;

import com.chong.userapi.po.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface UserManageService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
    @RequestMapping(value = "/hello5", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
