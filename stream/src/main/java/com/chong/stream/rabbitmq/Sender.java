package com.chong.stream.rabbitmq;

import com.chong.stream.po.User;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

//@EnableBinding(value = {Sender.SinkOutPut.class})
public class Sender {
    private static Logger logger  = LoggerFactory.getLogger(Sender.class);

//    @Bean
//    @InboundChannelAdapter(value = SinkOutPut.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        System.out.println("send date message......");
        return  () -> new GenericMessage<>(new Date());
    }

    /*@Bean
    @InboundChannelAdapter(value = SinkOutPut.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> timeMessageSource() {
        return  () -> new GenericMessage<>("{\"id\":1, \"name\":\"chong\"}");
        //return  () -> new GenericMessage<>(new User(1, "chong"));
    }*/

    public interface SinkOutPut {
        String OUTPUT = "input";

        @Output(SinkOutPut.OUTPUT)
        MessageChannel output();
    }
}
