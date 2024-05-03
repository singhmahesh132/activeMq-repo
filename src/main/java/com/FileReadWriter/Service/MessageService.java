package com.FileReadWriter.Service;

import com.FileReadWriter.Messaging.MQPublisher;
import com.FileReadWriter.ReqResp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    @Autowired
    MQPublisher publisher;

    public Response pushMessage(String message){
        logger.info("publishing message");
        publisher.sendMessage(message);
        Map<String,Object> msg = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        msg.put("msg","Request submitted successfully.");
        return new Response("SUCCESS",data,msg);
    }
}
