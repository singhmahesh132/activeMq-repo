package com.FileReadWriter.Messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MQListener {
    private static final Logger logger = LoggerFactory.getLogger(MQListener.class);
    @JmsListener(destination="myQueue", containerFactory = "factory")
    public void receiveMessage(String message){
        logger.info("message is :"+message);
    }
}
