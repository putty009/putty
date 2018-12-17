package com.chong.user.service;

import com.chong.puttycommon.po.User;
import com.chong.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SendService sendService;

    public User selectById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int addUser(User record){
        try {
            int i = userMapper.insertSelective(record);
            sendService.addMessage();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deletebyId(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
