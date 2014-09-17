package com.app.ttfo.callback;

import com.app.ttfo.exception.JoinGroupException;
import com.app.ttfo.response.JoinGroupResponse;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public interface JoinGroupCallback {
    void onFail(JoinGroupException exception);
    void onSuccess(JoinGroupResponse response);
}
