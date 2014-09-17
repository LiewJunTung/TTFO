package com.app.ttfo.api;

import android.content.Context;

import com.app.ttfo.callback.CreateGroupCallback;
import com.app.ttfo.callback.JoinGroupCallback;
import com.app.ttfo.callback.LoginCallback;
import com.app.ttfo.callback.MemberCallback;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public interface TTFOApi {
    void joinGroup(Context context, String groupCode, String name, String email, JoinGroupCallback callback);
    void createGroup(Context context, String groupCode, String name, String email, CreateGroupCallback callback);
    void createMember(Context context, String username, String password, String email, MemberCallback callback);
    void login(Context context, String username, String password, LoginCallback callback);
}
