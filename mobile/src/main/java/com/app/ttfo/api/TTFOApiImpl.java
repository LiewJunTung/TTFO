package com.app.ttfo.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.app.ttfo.callback.CreateGroupCallback;
import com.app.ttfo.callback.JoinGroupCallback;
import com.app.ttfo.callback.LoginCallback;
import com.app.ttfo.callback.MemberCallback;
import com.app.ttfo.exception.CreateGroupException;
import com.app.ttfo.exception.JoinGroupException;
import com.app.ttfo.exception.LoginException;
import com.app.ttfo.exception.MemberException;
import com.app.ttfo.request.CreateGroupRequest;
import com.app.ttfo.request.JoinGroupRequest;
import com.app.ttfo.request.LoginRequest;
import com.app.ttfo.request.MemberRequest;
import com.app.ttfo.response.CreateGroupResponse;
import com.app.ttfo.response.JoinGroupResponse;
import com.app.ttfo.response.LoginResponse;
import com.app.ttfo.response.MemberResponse;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public enum TTFOApiImpl implements TTFOApi {

    INSTANCE;

    private RequestQueue rq;

    @Override
    public void joinGroup(Context context, String groupCode, String name, String email, final JoinGroupCallback callback) {
        String url = "http://ttfo.herokapp.com/joinGroup";
        JoinGroupRequest request = new JoinGroupRequest(Request.Method.POST, url, groupCode, name, email, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFail(new JoinGroupException(error.getMessage(), error));
            }
        }, new Response.Listener<JoinGroupResponse>() {
            @Override
            public void onResponse(JoinGroupResponse response) {
                callback.onSuccess(response);
            }
        });
        getRequestQueue(context).add(request);
    }

    @Override
    public void createGroup(Context context, String groupCode, String name, String email, final CreateGroupCallback callback) {
        String url = "http://ttfo.herokapp.com/createGroup";

        CreateGroupRequest request = new CreateGroupRequest(Request.Method.POST, url, groupCode, name, email, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFail(new CreateGroupException(error.getMessage(), error));
            }
        }, new Response.Listener<CreateGroupResponse>() {
            @Override
            public void onResponse(CreateGroupResponse response) {
                callback.onSuccess(response);
            }
        });
        getRequestQueue(context).add(request);
    }

    @Override
    public void createMember(Context context, String username, String password, String email, final MemberCallback callback) {
        String url = "http://ttfo.herokapp.com/createGroup";
        MemberRequest request = new MemberRequest(Request.Method.POST, url, username, password, email, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFail(new MemberException(error.getMessage(), error));
            }
        }, new Response.Listener<MemberResponse>() {
            @Override
            public void onResponse(MemberResponse response) {
                callback.onSuccess(response);
            }
        });

        getRequestQueue(context).add(request);
    }

    @Override
    public void login(Context context, String username, String password, final LoginCallback callback) {
        String url = "";

        LoginRequest request = new LoginRequest(Request.Method.POST, url, username, password, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFail(new LoginException(error.getMessage(), error));
            }
        }, new Response.Listener<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse response) {
                callback.onSuccess(response);
            }
        });
        getRequestQueue(context).add(request);
    }

    private synchronized RequestQueue getRequestQueue(Context context) {
        if (rq == null) {
            rq = Volley.newRequestQueue(context);
        }
        return rq;
    }

}
