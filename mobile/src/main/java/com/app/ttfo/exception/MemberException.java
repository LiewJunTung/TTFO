package com.app.ttfo.exception;

import android.util.Log;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class MemberException extends RuntimeException{
    public MemberException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        Log.e("create member", detailMessage, throwable);
    }
}
