package com.app.ttfo.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class CreateGroupResponse {

    private String message;

    private boolean result;

    @SerializedName("groupid")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CreateGroupResponse{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
