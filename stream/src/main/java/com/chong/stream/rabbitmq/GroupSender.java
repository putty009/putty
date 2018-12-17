package com.chong.stream.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

//@EnableBinding(value = {Source.class})
public class GroupSender {
    private static Logger logger  = LoggerFactory.getLogger(GroupSender.class);

    /*@Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        System.out.println("i am sending message......");
        return  () -> new GenericMessage<>(new Date());
    }*/

//    @Bean
//    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timeMessageSource() {
        System.out.println("i am sending message......");
        return  () -> new GenericMessage<>("{\"name\":\"chong\", \"age\":24}");
        //return  () -> new GenericMessage<>(new User(1, "chong"));
    }
}
