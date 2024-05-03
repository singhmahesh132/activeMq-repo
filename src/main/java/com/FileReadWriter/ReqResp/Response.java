package com.FileReadWriter.ReqResp;

import java.util.Map;

public class Response {
    private String status;
    private Map<String, Object> data;

    private Map<String, Object> message;

    public Response(String status, Map<String, Object> data, Map<String, Object> message){
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getMessage() {
        return message;
    }

    public void setMessage(Map<String, Object> message) {
        this.message = message;
    }
}
