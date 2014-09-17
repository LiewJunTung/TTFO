package com.app.ttfo.request;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.app.ttfo.response.CreateGroupResponse;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class CreateGroupRequest extends Request<CreateGroupResponse> {

    private Response.Listener<CreateGroupResponse> listener;
    private String groupCode;
    private String name;
    private String email;

    public CreateGroupRequest(int method, String url, String groupCode, String name, String email, Response.ErrorListener errorListener, Response.Listener<CreateGroupResponse> listener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.groupCode = groupCode;
        this.name = name;
        this.email = email;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("groupCode", groupCode);
        params.put("name", name);
        params.put("email", email);
        return params;
    }

    @Override
    protected Response<CreateGroupResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            CreateGroupResponse createGroupResponse = new Gson().fromJson(json, CreateGroupResponse.class);
            return Response.success(createGroupResponse, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError(e.getMessage(), e));
        }
    }

    @Override
    protected void deliverResponse(CreateGroupResponse response) {
        listener.onResponse(response);
    }
}
