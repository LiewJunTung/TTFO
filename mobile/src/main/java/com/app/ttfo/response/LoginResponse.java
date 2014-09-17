package com.app.ttfo.response;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class LoginResponse {

    private boolean result;

    private String message;

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
