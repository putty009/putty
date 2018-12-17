package com.chong.user.service;

import com.chong.puttycommon.channel.UserChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(UserChannel.class)
public class SendService {

    @Autowired
    private UserChannel userChannel;

    public void addMessage() {
        System.out.println("send a message of add success");
        userChannel.ouput().send(MessageBuilder.withPayload("add a user").
                setHeader("module", "user").build());
    }
}
