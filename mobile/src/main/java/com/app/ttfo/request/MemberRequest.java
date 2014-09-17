package com.app.ttfo.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.app.ttfo.response.JoinGroupResponse;
import com.app.ttfo.response.MemberResponse;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class MemberRequest extends Request<MemberResponse> {

    private String username;
    private String password;
    private String email;
    private Response.Listener<MemberResponse> listener;

    public MemberRequest(int method, String url, String username, String password, String email, Response.ErrorListener errorListener, Response.Listener<MemberResponse> listener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        params.put("email", email);
        return params;
    }

    @Override
    protected Response<MemberResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            MemberResponse memberResponse = new Gson().fromJson(json, MemberResponse.class);
            return Response.success(memberResponse, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError(e.getMessage(), e));
        }
    }

    @Override
    protected void deliverResponse(MemberResponse response) {
        listener.onResponse(response);
    }
}
