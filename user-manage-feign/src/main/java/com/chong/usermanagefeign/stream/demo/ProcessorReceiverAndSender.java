package com.chong.usermanagefeign.stream.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*监听input，发送output*/
//@EnableBinding(value = {Processor.class})
public class ProcessorReceiverAndSender {
    private static Logger logger  = LoggerFactory.getLogger(ProcessorReceiverAndSender.class);

//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received: "+payload);
        return "From Input channel return - "+payload;
    }
}

/*原生注解的方式*/
/*@EnableScheduling
@EnableBinding(value = {Processor.class})
public class ProcessorReceiverAndSender {
    private static Logger logger  = LoggerFactory.getLogger(ProcessorReceiverAndSender.class);

    @ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received: "+payload);
        return "From Input channel return - "+payload;
    }
}*/
