package com.app.ttfo.api;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public enum ApiFactory {

    INSTANCE;

    public TTFOApi getTTFOApi(){
        return TTFOApiImpl.INSTANCE;
    }
}
