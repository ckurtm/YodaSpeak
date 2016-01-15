package com.peirr.yodaspeak.model;

/**
 * Created by kurt on 2016/01/14.
 */
public interface YodaModel {

    interface RequestCallback {
        void onRequestCompleted(String text,Throwable t);
    }

    void requestText(String text,RequestCallback callback);
}
