package com.chong.user.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/*发送output，监听input*/
//@EnableBinding(value = {Processor.class})
public class ProcessorReceiveFromOutput {
    private static Logger logger  = LoggerFactory.getLogger(ProcessorReceiveFromOutput.class);

//    @Bean
//    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

//    @StreamListener(Processor.INPUT)
    public void receiveFromOutput(Object payload) {
        logger.info("Received: "+payload);
    }
}
