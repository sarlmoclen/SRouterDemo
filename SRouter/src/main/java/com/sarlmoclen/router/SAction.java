package com.sarlmoclen.router;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by sarlmoclen on 2017/5/23.
 */

public abstract class SAction {

    public abstract Object startAction(Context context, HashMap<String,Object> requestData);

}
