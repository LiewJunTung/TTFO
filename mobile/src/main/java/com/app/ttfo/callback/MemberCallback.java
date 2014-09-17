package com.app.ttfo.callback;

import com.app.ttfo.exception.MemberException;
import com.app.ttfo.response.MemberResponse;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public interface MemberCallback {

    void onFail(MemberException exception);
    void onSuccess(MemberResponse response);


}
