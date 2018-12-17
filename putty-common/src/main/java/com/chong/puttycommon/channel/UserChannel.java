package com.chong.puttycommon.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannel {
    String INPUT = "userInput";
    String OUTPUT = "userOutput";

    @Input(UserChannel.INPUT)
    SubscribableChannel input();

    @Output(UserChannel.OUTPUT)
    MessageChannel ouput();
}
