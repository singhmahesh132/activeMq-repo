package com.FileReadWriter.Service;

import com.FileReadWriter.Messaging.AMQPublisher;
import com.FileReadWriter.ReqResp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    AMQPublisher publisher;

    public Response pushMessage(String message){
        publisher.sendMessage(message);
        Map<String,Object> msg = new HashMap<>();
        Map<String,Object> data = new HashMap<>();
        msg.put("Msg","request submitted successfully");
        return new Response("SUCCESS",data,msg);
    }
}
