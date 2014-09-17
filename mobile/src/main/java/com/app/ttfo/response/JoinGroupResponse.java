package com.app.ttfo.response;

import com.app.ttfo.domain.Member;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class JoinGroupResponse {

    private boolean result;

    private Member member;

    private String message;

    public boolean isResult() {
        return result;
    }

    public Member getMember() {
        return member;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "JoinGroupResponse{" +
                "result=" + result +
                ", member=" + member +
                ", message='" + message + '\'' +
                '}';
    }
}
