package com.app.ttfo.exception;

import android.util.Log;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class CreateGroupException extends RuntimeException {
    public CreateGroupException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        Log.e("create group", detailMessage, throwable);
    }
}
