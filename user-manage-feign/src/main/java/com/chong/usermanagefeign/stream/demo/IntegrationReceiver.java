package com.chong.usermanagefeign.stream.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

//@EnableBinding(value = {Sink.class})
public class IntegrationReceiver {
    private static Logger logger  = LoggerFactory.getLogger(IntegrationReceiver.class);

//    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Receive From spring integration: "+payload);
    }

    /*转换消息格式*/
//    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

    /*@ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(User user) {
        logger.info("Receive From spring integration: "+user);
    }

    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public User transform(String message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message, User.class);
        return user;
    }*/
}
