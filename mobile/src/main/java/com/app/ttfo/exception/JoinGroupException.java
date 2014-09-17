package com.app.ttfo.exception;

import android.util.Log;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class JoinGroupException extends RuntimeException{

    public JoinGroupException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        Log.e("join group", detailMessage, throwable);
    }
}
