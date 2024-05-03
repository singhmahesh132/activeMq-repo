package com.FileReadWriter.Messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MQPublisher {

    private static final Logger logger = LoggerFactory.getLogger(MQPublisher.class);
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message){
        logger.info("Publishing message");
        jmsTemplate.convertAndSend("myQueue",message);
        logger.info("Published message");
    }
}
