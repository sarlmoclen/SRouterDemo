package com.sarlmoclen.demo.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sarlmoclen.demo.MainActivity;
import com.sarlmoclen.router.SAction;
import com.sarlmoclen.router.utils.SLog;

import java.util.HashMap;

/**
 * Created by sarlmoclen on 2017/5/25.
 */

public class MainAction extends SAction{

    @Override
    public Object startAction(Context context, HashMap<String, Object> requestData) {
        if(requestData.containsKey("test_high")){
            SLog.e(SLog.TAG,requestData.get("test_high").toString());
            return "test_high";
        }
        if(context instanceof Activity){
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("from",requestData.get("from").toString());
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("from",requestData.get("from").toString());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return "arrive main success!";
    }

}
