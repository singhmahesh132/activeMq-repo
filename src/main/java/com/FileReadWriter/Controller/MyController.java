package com.FileReadWriter.Controller;

import com.FileReadWriter.ReqResp.Request;
import com.FileReadWriter.ReqResp.Response;
import com.FileReadWriter.Service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MyController{
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    @Autowired
    MessageService mservice;

    @PostMapping(path = "/readFile")
    public void readFile(@RequestParam(name="filepath") String filepath){
        System.out.println("in readFile");
        System.out.println("filepath = "+filepath);

    }

    @RequestMapping(value = {"/sendMessage"}, consumes = {"application/json"}, produces = {"application/json"}, method = {RequestMethod.POST})
    public Response sendMessage(@RequestBody Request request) throws Exception{
        logger.info("in MYController.sendMessage()");
        Map<String,Object> reqVO = request.getData();
        String message = reqVO.get("message").toString();
        return mservice.pushMessage(message);
    }
}
