package com.sarlmoclen.router.utils;

import android.util.Log;

/**
 * Created by sarlmoclen on 2017/5/23.
 */

public class SLog {

    public final static String TAG = "SRouter";
    public final static int ERROR = 1;
    public final static int WARN = 2;
    public final static int INFO = 3;
    public final static int DEBUG = 4;
    public final static int VERBOSE = 5;

    public static int LOG_LEVEL = ERROR;


    public static void e(String tag, String msg) {
        if (LOG_LEVEL >= ERROR)
            Log.e(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (LOG_LEVEL >= WARN)
            Log.w(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (LOG_LEVEL >= INFO)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (LOG_LEVEL >= DEBUG)
            Log.d(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (LOG_LEVEL >= VERBOSE)
            Log.v(tag, msg);
    }
}
