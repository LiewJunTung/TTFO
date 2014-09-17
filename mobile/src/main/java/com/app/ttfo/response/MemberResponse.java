package com.app.ttfo.response;

import com.app.ttfo.domain.Member;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class MemberResponse {
    private boolean result;
    private String message;
    private Member member;

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", member=" + member +
                '}';
    }
}
