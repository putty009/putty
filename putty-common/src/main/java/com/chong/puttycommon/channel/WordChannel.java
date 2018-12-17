package com.chong.puttycommon.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface WordChannel {
    String INPUT = "wordInput";
    String OUTPUT = "wordOutput";

    @Input(WordChannel.INPUT)
    SubscribableChannel input();

    @Output(WordChannel.OUTPUT)
    MessageChannel ouput();
}
