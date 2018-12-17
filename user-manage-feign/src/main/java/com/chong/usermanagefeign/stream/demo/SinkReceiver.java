package com.chong.usermanagefeign.stream.demo;


import com.chong.puttycommon.po.TestPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
//@EnableBinding(value = {Sink.class, SinkSender.class})  //可以绑定多个接口
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /*@StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("received: "+payload);
    }*/


    //接收一个对象
    @StreamListener(Sink.INPUT)
    public void receive(TestPo payload) {
        logger.info("received: "+payload);
    }
}


