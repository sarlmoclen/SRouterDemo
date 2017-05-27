package com.sarlmoclen.router;

import java.util.HashMap;

/**
 * Created by sarlmoclen on 2017/5/23.
 */

public class SRouterRequest {

    private String action;
    private HashMap<String, Object> data;

    private SRouterRequest() {
        this.data = new HashMap<>();
    }

    public static SRouterRequest creat(){
        return new SRouterRequest();
    }

    public SRouterRequest data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public SRouterRequest action(String action) {
        this.action = action;
        return this;
    }

    public HashMap<String, Object> getData() {
        return this.data;
    }

    public String getAction() {
        return this.action;
    }

}
