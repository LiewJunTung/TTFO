package com.app.ttfo.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.app.ttfo.response.LoginResponse;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class LoginRequest extends Request<LoginResponse> {

    private Response.Listener<LoginResponse> listener;
    private String username;
    private String password;

    public LoginRequest(int method, String url, String username, String password, Response.ErrorListener errorListener, Response.Listener<LoginResponse> listener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.username = username;
        this.password = password;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        return params;
    }

    @Override
    protected Response<LoginResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            LoginResponse loginResponse = new Gson().fromJson(json, LoginResponse.class);
            return Response.success(loginResponse, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError(e.getMessage(), e));
        }
    }

    @Override
    protected void deliverResponse(LoginResponse response) {
        listener.onResponse(response);
    }
}
