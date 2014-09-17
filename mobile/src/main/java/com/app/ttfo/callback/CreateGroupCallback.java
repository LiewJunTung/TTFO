package com.app.ttfo.callback;

import com.app.ttfo.exception.CreateGroupException;
import com.app.ttfo.response.CreateGroupResponse;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public interface CreateGroupCallback {
    void onFail(CreateGroupException exception);
    void onSuccess(CreateGroupResponse response);
}
