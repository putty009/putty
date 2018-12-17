package com.chong.usermanagefeign.stream;


import com.chong.puttycommon.channel.UserChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

//@EnableBinding(UserChannel.class)
public class UserReceiver {
    private static Logger logger = LoggerFactory.getLogger(UserReceiver.class);

//    @StreamListener(UserChannel.INPUT)
    public void receive(Object payload) {
        logger.info("received: "+payload);
    }


    //接收一个对象
    /*@StreamListener(UserChannel.INPUT)
    public void receive(TestPo payload) {
        logger.info("received: "+payload);
    }*/
}


