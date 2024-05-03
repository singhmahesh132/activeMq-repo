package com.FileReadWriter.ReqResp;

import java.util.Map;

public class Request {
    private String version;
    private Map<String, Object> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "version='" + version + '\'' +
                ", data=" + data +
                '}';
    }
}
