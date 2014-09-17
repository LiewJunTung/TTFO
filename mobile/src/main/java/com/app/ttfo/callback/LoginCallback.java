package com.app.ttfo.callback;

import com.app.ttfo.exception.LoginException;
import com.app.ttfo.response.LoginResponse;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public interface LoginCallback {
    void onFail(LoginException exception);
    void onSuccess(LoginResponse response);
}
