package com.app.ttfo.domain;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class Member {

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
