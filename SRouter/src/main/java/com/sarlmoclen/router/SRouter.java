package com.sarlmoclen.router;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by sarlmoclen on 2017/5/23.
 */

public class SRouter {

    private static volatile SRouter mInstance = null;
    private HashMap<String, SAction> mActions = null;

    private SRouter(){
        mActions = new HashMap<>();
    }

    public static SRouter getInstance(){
        if(mInstance == null){
            synchronized (SRouter.class){
                if(mInstance == null){
                    mInstance = new SRouter();
                }
            }
        }
        return mInstance;
    }

    public SRouterResponse sendMessage(Context c,SRouterRequest mSRouterRequest){
        SRouterResponse mSRouterResponse = new SRouterResponse();
        SAction mSAction = findRequest(mSRouterRequest);
        if(mSAction != null){
            Object mObject = mSAction.invoke(c,mSRouterRequest.getData());
            mSRouterResponse.setStatus(SRouterResponse.SUCCESS_CODE
                    ,SRouterResponse.SUCCESS_DESC
                    ,mObject);
        }else{
            mSRouterResponse.setStatus(SRouterResponse.Fail_CODE
                    ,SRouterResponse.Fail_DESC
                    ,"can not find this action,check to see if you have been registered!");
        }
        return mSRouterResponse;
    }

    private SAction findRequest(SRouterRequest mSRouterRequest){
        String action = mSRouterRequest.getAction();
        if(mActions.containsKey(action)){
            return mActions.get(action);
        }
        return null;
    }

    public void registerAction(String action,SAction mSAction){
        mActions.put(action,mSAction);
    }

}
