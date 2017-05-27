package com.sarlmoclen.router;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sarlmoclen on 2017/5/23.
 */

public class SRouterResponse {

    public final static int SUCCESS_CODE = 1;
    public final static int Fail_CODE = 0;
    public final static String SUCCESS_DESC = "success";
    public final static String Fail_DESC = "fail";
    private int statusCode;
    private String statusDesc;
    private Object body;

    public JSONObject getResult(){
        JSONObject jsResult = null;
        try {
            jsResult = new JSONObject()
                    .put("statusCode",statusCode)
                    .put("statusDesc",statusDesc)
                    .put("body",body);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsResult;
    }

    public void setStatus(int statusCode,
                        String statusDesc,
                        Object body){
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
        this.body = body;
    }

}
