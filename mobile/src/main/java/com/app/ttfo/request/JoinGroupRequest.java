package com.app.ttfo.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.app.ttfo.response.JoinGroupResponse;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class JoinGroupRequest extends Request<JoinGroupResponse> {

    private Response.Listener<JoinGroupResponse> listener;
    private String groupCode;
    private String username;

    public JoinGroupRequest(int method, String url, String groupCode, String username,  Response.ErrorListener errorListener, Response.Listener<JoinGroupResponse> listener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.groupCode = groupCode;
        this.username = username;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("groupid", groupCode);
        params.put("username", username);
        return params;
    }

    @Override
    protected Response<JoinGroupResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            JoinGroupResponse joinGroupResponse = new Gson().fromJson(json, JoinGroupResponse.class);
            return Response.success(joinGroupResponse, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError(e.getMessage(), e));
        }
    }

    @Override
    protected void deliverResponse(JoinGroupResponse response) {
        listener.onResponse(response);
    }
}
